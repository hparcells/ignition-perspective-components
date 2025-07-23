import { ComponentMeta, ComponentRegistry } from '@inductiveautomation/perspective-client';

import { Button, ButtonMeta } from './components/Button/Button';
import { DragRepeater, DragRepeaterMeta} from './components/DragRepeater/DragRepeater';
import { Alert, AlertMeta} from './components/Alert/Alert';
import { DebouncedTextField, DebouncedTextFieldMeta } from './components/DebouncedTextField/DebouncedTextField';
import { BigNumber, BigNumberMeta } from './components/BigNumber/BigNumber';
import { Calendar, CalendarMeta } from './components/Calendar/Calendar';

export {
  Button,
  DragRepeater,
  Alert,
  DebouncedTextField,
  BigNumber,
  Calendar
};

const components: Array<ComponentMeta> = [
  new ButtonMeta(),
  new DragRepeaterMeta(),
  new AlertMeta(),
  new DebouncedTextFieldMeta(),
  new BigNumberMeta(),
  new CalendarMeta()
];

components.forEach((c: ComponentMeta) => {
  ComponentRegistry.register(c);
});
