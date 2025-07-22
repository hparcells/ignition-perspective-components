import * as React from 'react';
import { ComponentMeta, ComponentProps, PComponent, PropertyTree, SizeObject, View } from "@inductiveautomation/perspective-client";

import { swap } from '../../util/array';

import './DragRepeater.scss';

export const COMPONENT_TYPE = 'hc.container.dragrepeater';

export interface Props {
  instances: any[];
  view: string;

  setInstances: (instances: any[]) => void;
}

export function DragRepeater(props: ComponentProps<Props>) {
  const {
    props: {
      instances,
      view,
      setInstances
    },
    emit
  } = props;

  const [draggingIndex, setDraggingIndex] = React.useState<number>(-1);

  function handleDragStart(index: number) {
    setDraggingIndex(index);
  }

  function handleDrop(index: number) {
    if(draggingIndex < 0 || draggingIndex == index) {
      return;
    }
    
    setInstances(swap(instances, draggingIndex, index));

    setDraggingIndex(-1);
  }

  return (
    <div {...emit({ classes: ['drag-column'] })}>
      {
        instances.map((instance, i) => {
          return (
            <div
              draggable
              onDragStart={() => {
                handleDragStart(i)
              }}
              onDragOver={(e) => {
                e.preventDefault();
              }}
              onDrop={() => {
                handleDrop(i);
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
      width: 300,
      height: 600
    };
  }
  getPropsReducer(tree: PropertyTree): Props {
    return {
      instances: tree.readArray('instances', []),
      view: tree.readString('view', ''),
      
      setInstances: (instances: any[]) => {
        tree.write('instances', instances);
      }
    };
  }
}
