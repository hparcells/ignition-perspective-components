import * as React from 'react';

import './CalendarEvent.scss';
export interface CalendarEventData {
  date: Date;
  title: string;
  [key: string]: any;
}

function CalendarEvent({
  data,
  draggable,
  onClick,
  handleDragStart,
}: {
  data: CalendarEventData;
  draggable: boolean;
  onClick?: () => void;
  handleDragStart?: (data: CalendarEventData) => void;
}) {
  return (
    <div
      draggable={draggable}
      className='calender-event'
      onClick={() => {
        onClick && onClick();
      }}
      onDragStart={(e) => {
        if(!draggable) {
          return;
        }
        handleDragStart && handleDragStart(data);
      }}
    >
      <p>{data.title}</p>
    </div>
  );
}

export default CalendarEvent;
