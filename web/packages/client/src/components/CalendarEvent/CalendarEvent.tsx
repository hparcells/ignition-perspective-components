import * as React from 'react';

import './CalendarEvent.scss';

interface CalendarEventData {
  date: Date;
  title: string;
}

function CalendarEvent({
  data,
  onClick
}: {
  data: CalendarEventData;
  onClick?: () => void;
}) {
  return (
    <div
      className='calender-event'
      onClick={() => {
        onClick && onClick();
      }}
    >
      <p>{data.title}</p>
    </div>
  );
}

export default CalendarEvent;
