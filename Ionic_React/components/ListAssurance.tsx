import { IonCard, IonContent, IonHeader, IonTitle } from "@ionic/react";
import { useItems } from "../models/sendRequest";
import Assurance from "./Assurance";

interface nbmois{
    nbmois:any;
}

const ListAssurance: React.FC<nbmois> = ({nbmois}) =>
{
    console.log(`http://localhost:1234/assurances/expiration/${nbmois}`);
    var { item, error } = useItems(`http://localhost:1234/assurances/expiration/${nbmois}`);
    if (item.length == 0)
    {
        return <h1>Waiting...</h1>
    } else
    {
        return (
            <IonCard>
                <IonHeader>
                    <IonTitle>Expiration dans moins de {nbmois} moi(s)</IonTitle>
                </IonHeader>
                <IonContent fullscreen>
                    {item.map((it: any) =>
                    {
                        return <Assurance avion={it.avion} datepayement={new Date(it.datePayement).toISOString()} dateexpiration={new Date(it.dateExpiration).toISOString()}></Assurance>
                    })}
                </IonContent>
            </IonCard>);
    }


}

export default ListAssurance;
