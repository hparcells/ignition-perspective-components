import * as React from 'react';
import {
  Component,
  ComponentMeta,
  ComponentProps,
  PComponent,
  PropertyTree,
  SizeObject
} from '@inductiveautomation/perspective-client';

import './Button.scss';

export const COMPONENT_TYPE = "hc.input.button";

type ButtonVariant = 'primary' | 'secondary' | 'outline' | 'ghost' | 'icon';

export interface ButtonProps {
  text: string;
  variant: ButtonVariant;
  disabled: boolean;
}

export class Button extends Component<ComponentProps<ButtonProps>, any> {
  onActionPerformed = () => {
		this.props.componentEvents.fireComponentEvent("onActionPerformed", {});
	}
  
  render() {
    const {
      props: {
        text,
        variant,
        disabled
      },
      emit
    } = this.props;

    return (
      <button 
        {...emit({ classes: ['button', variant] })}
        onClick={this.onActionPerformed}
        disabled={disabled}
      >
        {text}
      </button>
    )
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
      height: 36
    });
  }
  getPropsReducer(tree: PropertyTree): ButtonProps {
    return {
      text: tree.readString("text", ""),
      variant: tree.readString("variant", "primary") as ButtonVariant,
      disabled: tree.readBoolean("disabled", false)
    };
  }
}
