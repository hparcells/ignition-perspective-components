import {ComponentMeta, ComponentRegistry} from '@inductiveautomation/perspective-client';
import { Image, ImageMeta } from './components/Image';
import { MessengerComponent, MessengerComponentMeta } from './components/Messenger';
import { TagCounter, TagCounterMeta } from './components/TagCounter';
import { Button, ButtonMeta } from './components/Button';

export {
    Button,
    Image,
    MessengerComponent,
    TagCounter
};

import '../scss/main';

const components: Array<ComponentMeta> = [
    new ImageMeta(),
    new MessengerComponentMeta(),
    new TagCounterMeta(),
    new ButtonMeta()
];
components.forEach((c: ComponentMeta) => {
    ComponentRegistry.register(c)
});
