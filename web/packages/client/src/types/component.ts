export type AlertVariant = 'success' | 'warning' | 'error' | 'info';
export type ButtonVariant = 'primary' | 'secondary' | 'outline' | 'ghost' | 'icon';
export interface CalendarEventData {
  date: Date;
  title: string;
  color: string;
  fontColor: string;
  [key: string]: unknown;
}

export interface CalenderColorData {
  background: string;
  text: string;
}
