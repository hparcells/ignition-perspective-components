import * as React from 'react';
import { Emitter, IconRenderer } from '@inductiveautomation/perspective-client';

import { ButtonVariant } from '@/types/component';

import './Button.scss';

export const COMPONENT_TYPE = 'hc.input.button';

function Button({
  text,
  variant,
  disabled,
  leftIcon,
  rightIcon,
  emit,
  onClick
}: {
  text: string;
  variant: ButtonVariant;
  disabled?: boolean;
  leftIcon?: string;
  rightIcon?: string;
  emit?: Emitter;
  onClick?: () => void;
}) {
  return (
    <button
      {...emit?.()}
      className={`button ${variant}`}
      onClick={onClick}
      disabled={disabled}
    >
      {leftIcon && (
        <IconRenderer
          path={leftIcon}
          style={{
            width: 20,
            height: 20
          }}
        />
      )}
      {text}
      {rightIcon && (
        <IconRenderer
          path={rightIcon}
          style={{
            width: 20,
            height: 20
          }}
        />
      )}
    </button>
  );
}

export default Button;
