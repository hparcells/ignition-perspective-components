import * as React from 'react';

import './CalendarEvent.scss';

interface CalendarEventData {
  date: Date;
  title: string;
}

function CalendarEvent({
  data
}: {
  data: CalendarEventData;
}) {
  return (
    <div className='calender-event'>
      <p>{data.title}</p>
    </div>
  );
}

export default CalendarEvent;
