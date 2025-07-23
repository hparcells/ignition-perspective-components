import { ComponentMeta, ComponentRegistry } from '@inductiveautomation/perspective-client';

import { Button, ButtonMeta } from './components/Button/Button';
import { DragRepeater, DragRepeaterMeta} from './components/DragRepeater/DragRepeater';
import { Alert, AlertMeta} from './components/Alert/Alert';
import { DebouncedTextField, DebouncedTextFieldMeta } from './components/DebouncedTextField/DebouncedTextField';
import { BigNumber, BigNumberMeta } from './components/BigNumber/BigNumber';

export {
  Button,
  DragRepeater,
  Alert,
  DebouncedTextField,
  BigNumber
};

const components: Array<ComponentMeta> = [
  new ButtonMeta(),
  new DragRepeaterMeta(),
  new AlertMeta(),
  new DebouncedTextFieldMeta(),
  new BigNumberMeta()
];

components.forEach((c: ComponentMeta) => {
  ComponentRegistry.register(c);
});
