import { IonApp, IonRouterOutlet, IonSplitPane, setupIonicReact } from '@ionic/react';
import { IonReactRouter } from '@ionic/react-router';
import { Redirect, Route } from 'react-router-dom';
import Menu from './components/Menu';
/* Core CSS required for Ionic components to work properly */
import '@ionic/react/css/core.css';

/* Basic CSS for apps built with Ionic */
import '@ionic/react/css/normalize.css';
import '@ionic/react/css/structure.css';
import '@ionic/react/css/typography.css';

/* Optional CSS utils that can be commented out */
import '@ionic/react/css/padding.css';
import '@ionic/react/css/float-elements.css';
import '@ionic/react/css/text-alignment.css';
import '@ionic/react/css/text-transformation.css';
import '@ionic/react/css/flex-utils.css';
import '@ionic/react/css/display.css';

/* Theme variables */
import './theme/variables.css';
import PageDetails from './pages/PageDetails';
import PageAssurance from './pages/PageAssurance';
import Expiration from './pages/Expiration';
import ListAvion from './pages/ListAvion';
import Login from './pages/Login';

setupIonicReact();

const App: React.FC = () => {
  return (
    <IonApp>
      <IonReactRouter>
        <IonSplitPane contentId="main">
          <Menu />
          <IonRouterOutlet id="main">
            <Route path="/" exact={true}>
              <Redirect to="/avions" />
            </Route>
            <Route path="/details/:idavion" exact={true}>
              <PageDetails />
            </Route>
            <Route path="/assurances/expiration/:nbmois" exact={true}>
              <PageAssurance />
            </Route>
            <Route path="/assurances/expiration" exact={true}>
              <Expiration/>
            </Route>
            <Route path="/avions" exact={true}>
              <ListAvion/>
            </Route>
            <Route path="/login" exact={true}>
              <Login/>
            </Route>
          </IonRouterOutlet>
        </IonSplitPane>
      </IonReactRouter>
    </IonApp>
  );
};

export default App;
