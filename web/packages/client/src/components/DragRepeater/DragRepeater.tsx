import './DragRepeater.scss';

import * as React from 'react';
import {
  ComponentMeta,
  ComponentProps,
  PComponent,
  PropertyTree,
  SizeObject,
  View
} from '@inductiveautomation/perspective-client';

import { swap } from '../../util/array';

export const COMPONENT_TYPE = 'hc.container.dragrepeater';

type DragRepeaterDirection = 'column' | 'row';

export interface Props {
  direction: DragRepeaterDirection;
  instances: {
    [key: string]: any;
  }[];
  view: string;
  instanceStyle: { [key: string]: any };
  instancePosition: {
    grow: number;
    shrink: number;
    basis: number;
  };
  setInstances: (instances: any[]) => void;
}

export function DragRepeater(props: ComponentProps<Props>) {
  const {
    props: { direction, instances, view, instanceStyle, instancePosition, setInstances },
    emit
  } = props;

  const [draggingIndex, setDraggingIndex] = React.useState<number>(-1);

  function handleDragStart(index: number) {
    setDraggingIndex(index);
    props.componentEvents.fireComponentEvent('onDragStart', {
      dragIndex: index
    });
  }

  function handleDrop(index: number) {
    if (draggingIndex < 0 || draggingIndex === index) {
      return;
    }

    setInstances(swap(instances, draggingIndex, index));

    props.componentEvents.fireComponentEvent('onDrop', {
      dragIndex: draggingIndex,
      dropIndex: index
    });

    setDraggingIndex(-1);
  }

  return (
    <div {...emit({ classes: ['drag-repeater', `drag-repeater-${direction}`] })}>
      {
        instances.map((
          instance: {
            [key: string]: any;
          },
          i: number
        ) => {
          return (
            <div
              draggable
              onDragStart={() => {
                handleDragStart(i);
              }}
              onDragOver={(e) => {
                e.preventDefault();
              }}
              onDrop={() => {
                handleDrop(i);
              }}
              style={{
                ...instanceStyle,
                flex: `${instancePosition.grow} ${instancePosition.shrink} ${instancePosition.basis}`
              }}
              key={i}
            >
              <View
                store={props.store.view.page.parent}
                mountPath={`${props.store.path}:${i}`}
                resourcePath={view}
                params={instance}
              />
            </div>
          );
        })
      }
    </div>
  );
}

export class DragRepeaterMeta implements ComponentMeta {
  getComponentType(): string {
    return COMPONENT_TYPE;
  }
  getViewComponent(): PComponent {
    return DragRepeater;
  }
  getDefaultSize(): SizeObject {
    return {
      width: 200,
      height: 200
    };
  }
  getPropsReducer(tree: PropertyTree): Props {
    return {
      direction: tree.readString('direction', 'column') as DragRepeaterDirection,
      instances: tree.readArray('instances', []),
      view: tree.readString('view', ''),
      instanceStyle: tree.readObject('instanceStyle', {}),
      instancePosition: tree.readObject('instancePosition', {
        grow: 1,
        shrink: 1,
        basis: 0
      }),
      setInstances: (instances: any[]) => {
        tree.write('instances', instances);
      }
    };
  }
}
