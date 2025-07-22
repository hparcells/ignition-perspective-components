import { ComponentMeta, ComponentRegistry } from '@inductiveautomation/perspective-client';

import { Button, ButtonMeta } from './components/Button/Button';
import { DragOrderableColumn, DragOrderableColumnMeta} from './components/DragOrderableColumn/DragOrderableColumn';

export {
  Button,
  DragOrderableColumn
};

const components: Array<ComponentMeta> = [
  new ButtonMeta(),
  new DragOrderableColumnMeta()
];

components.forEach((c: ComponentMeta) => {
  ComponentRegistry.register(c);
});
