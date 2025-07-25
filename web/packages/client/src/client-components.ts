import { ComponentMeta, ComponentRegistry } from '@inductiveautomation/perspective-client';

import { AlertMeta } from './client-components/Alert/Alert';
import { BigNumberMeta } from './client-components/BigNumber/BigNumber';
import { ButtonMeta } from './client-components/Button/Button';
import { CalendarMeta } from './client-components/Calendar/Calendar';
import { DebouncedTextFieldMeta } from './client-components/DebouncedTextField/DebouncedTextField';
import { DragRepeaterMeta } from './client-components/DragRepeater/DragRepeater';
import { SequentialMonthPickerMeta } from './client-components/SequentialMonthPicker/SequentialMonthPicker';

const components: ComponentMeta[] = [
  new ButtonMeta(),
  new DragRepeaterMeta(),
  new AlertMeta(),
  new DebouncedTextFieldMeta(),
  new BigNumberMeta(),
  new CalendarMeta(),
  new SequentialMonthPickerMeta()
];

components.forEach((c: ComponentMeta) => {
  ComponentRegistry.register(c);
});
