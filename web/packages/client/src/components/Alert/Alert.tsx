import * as React from 'react';
import {
  ComponentMeta,
  ComponentProps,
  IconRenderer,
  PComponent,
  PropertyTree,
  SizeObject
} from '@inductiveautomation/perspective-client';

import './Alert.scss';

export const COMPONENT_TYPE = 'hc.ui.alert';

type AlertVariant = 'success' | 'warning' | 'error' | 'info';

export interface AlertProps {
  title: string;
  message: string;
  icon: string;
  variant: AlertVariant;
  filled: boolean;
  dismissible: boolean;
}

export function Alert(props: ComponentProps<AlertProps>) {
  const {
    props: { title, message, icon, variant, filled, dismissible },
    emit
  } = props;

  return (
    <div {...emit({ classes: [`alert-${variant}${filled ? '-filled' : ''}`] })}>
      <div className='alert-header'>
        <IconRenderer path={icon} style={{width: 20, height: 20}} />
        <p className='alert-title'>{title}</p>
      </div>
      <p className='alert-message'>{message}</p>
      <p>{dismissible}</p>
    </div>
  );
}

export class AlertMeta implements ComponentMeta {
  getComponentType(): string {
    return COMPONENT_TYPE;
  }
  getViewComponent(): PComponent {
    return Alert;
  }
  getDefaultSize(): SizeObject {
    return {
      width: 500,
      // This is overridden in Alert.scss by !important.
      // :)
      height: 100
    };
  }
  getPropsReducer(tree: PropertyTree): AlertProps {
    return {
      title: tree.readString('title', 'Alert'),
      message: tree.readString('message', 'This is an example alert.'),
      icon: tree.readString('icon', 'info') as string,
      variant: tree.readString('variant', 'info') as AlertVariant,
      filled: tree.readBoolean('filled', false),
      dismissible: tree.readBoolean('dismissible', false)
    };
  }
}
