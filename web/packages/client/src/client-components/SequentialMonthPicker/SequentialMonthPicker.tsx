import * as React from 'react';
import {
  ComponentMeta,
  ComponentProps,
  PComponent,
  PropertyTree,
  SizeObject
} from '@inductiveautomation/perspective-client';
import { format } from 'date-fns';

import Button from '../../components/Button/Button';

import './SequentialMonthPicker.scss';

export const COMPONENT_TYPE = 'hc.input.sequentialmonthpicker';

export interface SequentialMonthPickerProps {
  month: number;
  year: number;
  dateFormat: string;
  preventPast: boolean;
  preventFuture: boolean;
  disabled: boolean;
  incrementMonth: () => void;
  decrementMonth?: () => void;
}

export function SequentialMonthPicker(props: ComponentProps<SequentialMonthPickerProps>) {
  const {
    props: {
      month,
      year,
      dateFormat,
      preventPast,
      preventFuture,
      disabled,
      incrementMonth,
      decrementMonth
    },
    emit
  } = props;

  return (
    <div {...emit({ classes: ['sequential-month-picker'] })}>
      <Button
        text=''
        variant='primary'
        leftIcon='material/chevron_left'
        onClick={decrementMonth}
        disabled={
          disabled || (
            preventPast && month <= new Date().getMonth() + 1 && year <= new Date().getFullYear()
          )
        }
      />
      <p>{format(new Date(year, month - 1), dateFormat)}</p>
      <Button
        text=''
        variant='primary'
        leftIcon='material/chevron_right'
        onClick={incrementMonth}
        disabled={
          disabled || (
            preventFuture && month >= new Date().getMonth() + 1 && year >= new Date().getFullYear()
          )
        }
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
      dateFormat: tree.readString('dateFormat', 'LLLL yyyy'),
      year: tree.readNumber('year', new Date().getFullYear()),
      preventPast: tree.readBoolean('preventPast', false),
      preventFuture: tree.readBoolean('preventFuture', false),
      disabled: tree.readBoolean('disabled', false),
      incrementMonth: () => {
        const month = tree.readNumber('month', new Date().getMonth() + 1);
        const year = tree.readNumber('year', new Date().getFullYear());

        if (
          tree.readBoolean('preventFuture', false)
          && month >= new Date().getMonth() + 1
          && year >= new Date().getFullYear()
        ) {
          return;
        }

        const newMonth = month === 12 ? 1 : month + 1;
        const newYear = month === 12 ? year + 1 : year;

        tree.write('month', newMonth);
        tree.write('year', newYear);
      },
      decrementMonth: () => {
        const month = tree.readNumber('month', new Date().getMonth() + 1);
        const year = tree.readNumber('year', new Date().getFullYear());

        if (
          tree.readBoolean('preventPast', false)
          && month <= new Date().getMonth() + 1
          && year <= new Date().getFullYear()
        ) {
          return;
        }

        const newMonth = month === 1 ? 12 : month - 1;
        const newYear = month === 1 ? year - 1 : year;

        tree.write('month', newMonth);
        tree.write('year', newYear);
      }
    };
  }
}
