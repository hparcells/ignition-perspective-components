import * as React from 'react';
import {
  ComponentMeta,
  ComponentProps,
  PComponent,
  PropertyTree,
  SizeObject
} from '@inductiveautomation/perspective-client';

import './BigNumber.scss';

export const COMPONENT_TYPE = 'hc.ui.bignumber';

export interface BigNumberProps {
  text: string;
  value: number;
  prefix: string;
  suffix: string;
}

export function BigNumber(props: ComponentProps<BigNumberProps>) {
  const {
    props: {
      text,
      value,
      prefix,
      suffix
    },
    emit
  } = props;

  return (
    <div {...emit({ classes: ['big-number'] })}>
      <p className='big-number-text'>{text}</p>
      <p className='big-number-value'>{prefix}{value}{suffix}</p>
    </div>
  );
}

export class BigNumberMeta implements ComponentMeta {
  getComponentType(): string {
    return COMPONENT_TYPE;
  }

  getViewComponent(): PComponent {
    return BigNumber;
  }

  getDefaultSize(): SizeObject {
    return {
      width: 250,
      // This is overridden in BigNumber.scss by !important.
      // :)
      height: 100
    };
  }

  getPropsReducer(tree: PropertyTree): BigNumberProps {
    return {
      text: tree.readString('text', 'Apples'),
      value: tree.readNumber('value', 727),
      prefix: tree.readString('prefix', ''),
      suffix: tree.readString('suffix', '')
    };
  }
}
