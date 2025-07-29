import * as React from 'react';

import { CalendarEventData } from '@/types/component';

import { CALENDAR_COLORS } from '../../data/calendar';

import './CalendarEvent.scss';

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
  let color = data.color || '';
  let fontColor = data.fontColor;
  if (Object.keys(CALENDAR_COLORS).includes(color)) {
    fontColor ??= CALENDAR_COLORS[color].text;
    color = CALENDAR_COLORS[color].background;
  }

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
      style={{
        color: fontColor || '#ffffff',
        background: color || 'var(--qual-2)'
      }}
    >
      <p>{data.title}</p>
    </div>
  );
}

export default CalendarEvent;
