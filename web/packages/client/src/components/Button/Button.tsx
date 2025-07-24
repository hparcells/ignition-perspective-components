import * as React from 'react';
import {
  Component,
  ComponentMeta,
  ComponentProps,
  IconRenderer,
  PComponent,
  PropertyTree,
  SizeObject
} from '@inductiveautomation/perspective-client';

import './Button.scss';

export const COMPONENT_TYPE = 'hc.input.button';

type ButtonVariant = 'primary' | 'secondary' | 'outline' | 'ghost' | 'icon';

export interface ButtonProps {
  text: string;
  variant: ButtonVariant;
  disabled: boolean;
  leftIcon: string;
  rightIcon: string;
}

export class Button extends Component<ComponentProps<ButtonProps>, any> {
  onActionPerformed = () => {
    this.props.componentEvents.fireComponentEvent('onActionPerformed', {});
  };

  render() {
    const {
      props: { text,
        variant, disabled,
        leftIcon, rightIcon },
      emit
    } = this.props;

    return (
      <button
        {...emit({ classes: ['button', variant] })}
        onClick={this.onActionPerformed}
        disabled={disabled}
      >
        {
          leftIcon && (
            <IconRenderer
              path={leftIcon}
              style={{
                width: 20,
                height: 20
              }}
            />
          )
        }
        {text}
        {
          rightIcon && (
            <IconRenderer
              path={rightIcon}
              style={{
                width: 20,
                height: 20
              }}
            />
          )
        }
      </button>
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
    return {
      width: 80,
      height: 36
    };
  }
  getPropsReducer(tree: PropertyTree): ButtonProps {
    return {
      text: tree.readString('text', ''),
      variant: tree.readString('variant', 'primary') as ButtonVariant,
      disabled: tree.readBoolean('disabled', false),
      leftIcon: tree.readString('leftIcon', ''),
      rightIcon: tree.readString('rightIcon', '')
    };
  }
}
