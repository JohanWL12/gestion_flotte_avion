import { IonButton, IonItem, IonInput, IonLabel, IonPage, IonTitle, IonHeader, IonContent, IonToolbar, /*, useIonToast */ 
useIonToast} from "@ionic/react";
import { useState } from "react";
import axios from "axios";
import { getURL } from "../models/sendRequest";
import { useHistory } from "react-router";


const Login: React.FC = () => {
    const [mail, setEmail] = useState('rakoto@gmail.com');
    const [pwd, setPassword] = useState('root');

    const [toast] = useIonToast();
    const history = useHistory();

    function login() {
        axios.post(getURL('/users/login'), { email: mail, password: pwd })
            .then(response => {
                console.log(response.data);
                if (response.data.data != null) {
                    console.log(response.data.data.token);
                    localStorage.setItem('user_token', response.data.data.token);
                    history.push(`/avions`);
                } else {
                    toast({
                        message: "Vérifier vos identifiants",
                        duration: 2000,
                        position: 'bottom'
                    });
                }
            })
            .catch(error => {
                console.log(error);
            })
    };

    // setEmail("rakoto@gmail.com");
    // setPassword("root");

    return (
        <IonPage>
            <IonHeader>
                <IonToolbar>
                    <IonTitle>Connexion</IonTitle>
                </IonToolbar>
            </IonHeader>
            <IonContent>
                <form className="ion-padding">
                    <IonItem>
                        <IonLabel position="floating">Adresse email</IonLabel>
                        <IonInput onIonChange={(e: any) => setEmail(e.target.value)} value="rakoto@gmail.com"/>
                    </IonItem>
                    <IonItem>
                        <IonLabel position="floating">Mot de passe</IonLabel>
                        <IonInput onIonChange={(e: any) => setPassword(e.target.value)} type="password" value="root" />
                    </IonItem>
                    <IonButton onClick={login} className="ion-margin-top" expand="block">Se Connecter</IonButton>
                </form>
            </IonContent>
        </IonPage>
    );
};

export default Login;