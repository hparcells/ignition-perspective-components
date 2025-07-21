import { ComponentMeta, ComponentRegistry } from '@inductiveautomation/perspective-client';

import { Button, ButtonMeta } from './components/Button/Button';

export { Button };

const components: Array<ComponentMeta> = [new ButtonMeta()];
components.forEach((c: ComponentMeta) => {
  ComponentRegistry.register(c);
});
