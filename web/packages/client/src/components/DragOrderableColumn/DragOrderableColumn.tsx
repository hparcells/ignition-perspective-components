import * as React from 'react';
import { Component, ComponentMeta, ComponentProps, PComponent, PropertyTree, SizeObject, View } from "@inductiveautomation/perspective-client";

import './DragOrderableColumn.scss';

export const COMPONENT_TYPE = 'hc.container.dragcolumn';

export interface Props {
  instances: any[];
  view: string;
}

export class DragOrderableColumn extends Component<ComponentProps<Props>, any> {
  render() {
    const {
      props: { instances, view },
      emit
    } = this.props;

    return (
      <div {...emit({ classes: ['dragcolumn'] })}>
        {
          instances.map((instance, i) => {
            return (
              <div draggable key={i}>
                <View
                  store={this.props.store.view.page.parent}
                  mountPath={`${this.props.store.path}:${i}`}
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
}

export class DragOrderableColumnMeta implements ComponentMeta {
  getComponentType(): string {
    return COMPONENT_TYPE;
  }
  getViewComponent(): PComponent {
    return DragOrderableColumn;
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
      view: tree.readString('view', '')
    };
  }
}
