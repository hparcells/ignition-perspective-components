import * as React from 'react';
import {
  ComponentMeta,
  ComponentProps,
  PComponent,
  PropertyTree,
  SizeObject
} from '@inductiveautomation/perspective-client';

import ReactButton from '../../components/Button/Button';

import { ButtonVariant } from '@/types/component';

export const COMPONENT_TYPE = 'hc.input.button';

export interface ButtonProps {
  text: string;
  variant: ButtonVariant;
  disabled: boolean;
  leftIcon: string;
  rightIcon: string;
}

export function Button(props: ComponentProps<ButtonProps>) {
  function onActionPerformed() {
    props.componentEvents.fireComponentEvent('onActionPerformed', {});
  }

  const {
    props: {
      text,
      variant,
      disabled,
      leftIcon,
      rightIcon
    },
    emit
  } = props;

  return (
    <ReactButton
      text={text}
      variant={variant}
      disabled={disabled}
      leftIcon={leftIcon}
      rightIcon={rightIcon}
      emit={emit}
      onClick={onActionPerformed}
    />
  );
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
