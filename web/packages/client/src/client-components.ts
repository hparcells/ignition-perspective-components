import { ComponentMeta, ComponentRegistry } from '@inductiveautomation/perspective-client';

import { Button, ButtonMeta } from './components/Button/Button';
import { DragRepeater, DragRepeaterMeta} from './components/DragRepeater/DragRepeater';
import { Alert, AlertMeta} from './components/Alert/Alert';
import { DebouncedTextField, DebouncedTextFieldMeta } from './components/DebouncedTextField/DebouncedTextField';

export {
  Button,
  DragRepeater,
  Alert,
  DebouncedTextField  
};

const components: Array<ComponentMeta> = [
  new ButtonMeta(),
  new DragRepeaterMeta(),
  new AlertMeta(),
  new DebouncedTextFieldMeta()
];

components.forEach((c: ComponentMeta) => {
  ComponentRegistry.register(c);
});
