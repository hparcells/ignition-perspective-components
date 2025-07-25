import * as React from 'react';

import './CalendarEvent.scss';

export interface CalendarEventData {
  date: Date;
  title: string;
  [key: string]: unknown;
}

function CalendarEvent({
  data,
  draggable,
  onClick,
  handleDragStart
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
        if (onClick) {
          onClick();
        }
      }}
      onDragStart={() => {
        if (!draggable) {
          return;
        }
        if (handleDragStart) {
          handleDragStart(data);
        }
      }}
    >
      <p>{data.title}</p>
    </div>
  );
}

export default CalendarEvent;
