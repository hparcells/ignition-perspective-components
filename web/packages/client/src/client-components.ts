import { ComponentMeta, ComponentRegistry } from '@inductiveautomation/perspective-client';

import { Alert, AlertMeta } from './components/Alert/Alert';
import { BigNumber, BigNumberMeta } from './components/BigNumber/BigNumber';
import { Button, ButtonMeta } from './components/Button/Button';
import { Calendar, CalendarMeta } from './components/Calendar/Calendar';
import {
  DebouncedTextField,
  DebouncedTextFieldMeta
} from './components/DebouncedTextField/DebouncedTextField';
import { DragRepeater, DragRepeaterMeta } from './components/DragRepeater/DragRepeater';

export { Button, DragRepeater, Alert, DebouncedTextField, BigNumber, Calendar };

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
