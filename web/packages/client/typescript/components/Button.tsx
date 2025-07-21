import * as React from 'react';
import {
  Component,
  ComponentMeta,
  ComponentProps,
  PComponent,
  PropertyTree,
  SizeObject
} from '@inductiveautomation/perspective-client';

export const COMPONENT_TYPE = "hc.input.button";
export interface ButtonProps {
  text: string;
}
export class Button extends Component<ComponentProps<ButtonProps>, any> {
  onActionPerformed = () => {
		if (!this.props.eventsEnabled) {
			return;
		}

		this.props.componentEvents.fireComponentEvent("onActionPerformed", {});
	}
  
  render() {
    const { props: { text }, emit } = this.props;

    return (
      <button {...emit()}>{text}</button>
    );
  }
}

export class ButtonMeta implements ComponentMeta {
  getComponentType(): string {
    return COMPONENT_TYPE;
  }
  getViewComponent(): PComponent {
    return Button;
  }
  getDefaultSize(): SizeObject {
    return ({
      width: 80,
      height: 34
    });
  }
  getPropsReducer(tree: PropertyTree): ButtonProps {
    return {
      text: tree.readString("text", "")
    };
  }
}
