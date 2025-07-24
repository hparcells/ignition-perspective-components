import * as React from 'react';
import {
  ComponentMeta,
  ComponentProps,
  PComponent,
  PropertyTree,
  SizeObject
} from '@inductiveautomation/perspective-client';

import CalendarEvent from '../CalendarEvent/CalendarEvent';

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
      month,
      year,
      data
    },
    emit
  } = props;

  const [dayOfFirst, setDayOfFirst] = React.useState<number>(0);
  const [daysInMonth, setDaysInMonth] = React.useState<number>(0);
  const [monthEvents, setMonthEvents] = React.useState<CalendarEvent[]>([]);

  function buildCalendar() {
    const date = new Date(year, month - 1, 1);  
    setDayOfFirst(date.getDay());
    setDaysInMonth(new Date(year, month, 0).getDate());
  }
  function updateEvents() {
    const eventsForMonth = data.filter((event) => {
      const date = event.date;
      return date.getFullYear() === year && date.getMonth() + 1 === month;
    });
    setMonthEvents(eventsForMonth);
  }
  
  React.useEffect(() => {
    buildCalendar();
    updateEvents();
  }, [month, year]);
  React.useEffect(() => {
    updateEvents();
  }, [data]);

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
        Array.from({ length: 35 }).map((_, i) => {
          if (i < dayOfFirst || i >= dayOfFirst + daysInMonth) {
            return <div key={i} className='calendar-day'></div>;
          }
          
          return (
            <div key={i} className='calendar-day'>
              <p>{i - dayOfFirst + 1}</p>
              {
                monthEvents.map((event) => {
                  const eventDate = new Date(event.date);
                  if (eventDate.getDate() !== i - dayOfFirst + 1) {
                    return;
                  }
                  return (
                    <CalendarEvent
                      key={event.title}
                      data={event}
                      {...emit({ classes: ['calendar-event'] })}
                    />
                  );
                })
              }
            </div>
          );
        })
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
