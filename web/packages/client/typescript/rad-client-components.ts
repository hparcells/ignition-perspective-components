import {ComponentMeta, ComponentRegistry} from '@inductiveautomation/perspective-client';
import { Button, ButtonMeta } from './components/Button';

export {
    Button
};

import '../scss/main';

const components: Array<ComponentMeta> = [
    new ButtonMeta()
];
components.forEach((c: ComponentMeta) => {
    ComponentRegistry.register(c)
});
