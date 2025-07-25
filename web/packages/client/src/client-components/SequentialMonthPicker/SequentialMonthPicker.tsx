import * as React from 'react';
import {
  ComponentMeta,
  ComponentProps,
  PComponent,
  PropertyTree,
  SizeObject
} from '@inductiveautomation/perspective-client';

import Button from '../../components/Button/Button';

import './SequentialMonthPicker.scss';

export const COMPONENT_TYPE = 'hc.input.sequentialmonthpicker';

export interface SequentialMonthPickerProps {
  month: number;
  year: number;
  incrementMonth: () => void;
  decrementMonth?: () => void;
}

export function SequentialMonthPicker(props: ComponentProps<SequentialMonthPickerProps>) {
  const {
    props: { month, year, incrementMonth, decrementMonth },
    emit
  } = props;

  return (
    <div {...emit({ classes: ['sequential-month-picker'] })}>
      <Button
        text=''
        variant='primary'
        leftIcon='material/chevron_left'
        onClick={decrementMonth}
      />
      <p>{new Date(year, month - 1).toLocaleString('default', { month: 'long' })} {year}</p>
      <Button
        text=''
        variant='primary'
        leftIcon='material/chevron_right'
        onClick={incrementMonth}
      />
    </div>
  );
}

export class SequentialMonthPickerMeta implements ComponentMeta {
  getComponentType(): string {
    return COMPONENT_TYPE;
  }

  getViewComponent(): PComponent {
    return SequentialMonthPicker;
  }

  getDefaultSize(): SizeObject {
    return {
      width: 350,
      height: 50
    };
  }

  getPropsReducer(tree: PropertyTree): SequentialMonthPickerProps {
    return {
      month: tree.readNumber('month', new Date().getMonth() + 1),
      year: tree.readNumber('year', new Date().getFullYear()),
      incrementMonth: () => {
        const month = tree.readNumber('month', new Date().getMonth() + 1);
        const year = tree.readNumber('year', new Date().getFullYear());

        const newMonth = month === 12 ? 1 : month + 1;
        const newYear = month === 12 ? year + 1 : year;

        tree.write('month', newMonth);
        tree.write('year', newYear);
      },
      decrementMonth: () => {
        const month = tree.readNumber('month', new Date().getMonth() + 1);
        const year = tree.readNumber('year', new Date().getFullYear());

        const newMonth = month === 1 ? 12 : month - 1;
        const newYear = month === 1 ? year - 1 : year;

        tree.write('month', newMonth);
        tree.write('year', newYear);
      }
    };
  }
}
