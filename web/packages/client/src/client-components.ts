import { ComponentMeta, ComponentRegistry } from '@inductiveautomation/perspective-client';

import { Button, ButtonMeta } from './components/Button/Button';
import { DragRepeater, DragRepeaterMeta} from './components/DragRepeater/DragRepeater';

export {
  Button,
  DragRepeater
};

const components: Array<ComponentMeta> = [
  new ButtonMeta(),
  new DragRepeaterMeta()
];

components.forEach((c: ComponentMeta) => {
  ComponentRegistry.register(c);
});
