import { ComponentMeta, ComponentRegistry } from '@inductiveautomation/perspective-client';

import { Button, ButtonMeta } from './components/Button/Button';
import { DragRepeater, DragRepeaterMeta} from './components/DragRepeater/DragRepeater';
import { Alert, AlertMeta} from './components/Alert/Alert';

export {
  Button,
  DragRepeater,
  Alert
};

const components: Array<ComponentMeta> = [
  new ButtonMeta(),
  new DragRepeaterMeta(),
  new AlertMeta()
];

components.forEach((c: ComponentMeta) => {
  ComponentRegistry.register(c);
});
