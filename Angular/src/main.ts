import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

import { AppModule } from './app/app.module';

// Bootstrapping the BookHaven Angular application
platformBrowserDynamic().bootstrapModule(AppModule)
  .catch(err => console.error(err));
