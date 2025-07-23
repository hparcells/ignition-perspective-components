import * as React from 'react';
import {
  ComponentMeta,
  ComponentProps,
  PComponent,
  PropertyTree,
  SizeObject
} from '@inductiveautomation/perspective-client';

import './Calendar.scss';

export const COMPONENT_TYPE = 'hc.ui.calendar';

interface CalendarEvent {
  date: Date;
  title: string;
}

export interface CalendarProps {
  month: number;
  year: number;
  data: CalendarEvent[];
}

export function Calendar(props: ComponentProps<CalendarProps>) {
  const {
    props: {
      // month,
      // year,
      // data
    },
    emit
  } = props;

  React.useEffect(() => {

  }, []);

  return (
    <div {...emit({ classes: ['calendar'] })}>
      <div className='calendar-header'>
        <p>Sunday</p>
      </div>
      <div className='calendar-header'>
        <p>Monday</p>
      </div>
      <div className='calendar-header'>
        <p>Tuesday</p>
      </div>
      <div className='calendar-header'>
        <p>Wednesday</p>
      </div>
      <div className='calendar-header'>
        <p>Thursday</p>
      </div>
      <div className='calendar-header'>
        <p>Friday</p>
      </div>
      <div className='calendar-header'>
        <p>Saturday</p>
      </div>
      {
        Array.from({ length: 35 }).map((_, index) => (
          <div key={index} className='calendar-day'>
            {index + 1}
          </div>
        ))
      }
    </div>
  );
}

export class CalendarMeta implements ComponentMeta {
  getComponentType(): string {
    return COMPONENT_TYPE;
  }
  getViewComponent(): PComponent {
    return Calendar;
  }
  getDefaultSize(): SizeObject {
    return {
      width: 1400,
      height: 800
    };
  }
  getPropsReducer(tree: PropertyTree): CalendarProps {
    return {
      month: tree.readNumber('month', new Date().getMonth() + 1),
      year: tree.readNumber('year', new Date().getFullYear()),
      data: tree.readArray('data', []) as CalendarEvent[]
    };
  }
}
