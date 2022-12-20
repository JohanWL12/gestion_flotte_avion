import { IonButtons, IonCard, IonContent, IonHeader, IonItem, IonList, IonMenuButton, IonPage, IonSelect, IonSelectOption, IonTitle, IonToolbar } from "@ionic/react";
import { useParams } from "react-router";
import Assurance from "../components/Assurance";
import { useItems } from "../models/sendRequest";
import Expiration from "./Expiration";

const PageAssurance: React.FC = () =>
{
    const { nbmois } = useParams<{ nbmois: string; }>();

    // var display=function displayAssurance(assurances:Array<any>){
    //     var cards: Node[]=[];
    //     var content=document.getElementById("list");
    //     console.log(content);

    //     content?.querySelectorAll('*').forEach(element => element.remove());
    //     assurances.map((assurance)=>{
    //             cards.push(document.createElement('<Assurance avion={assurance.avion} datepayement={new Date(assurance.datePayement)} dateexpiration={new Date(assurance.dateExpiration)}></Assurance>'));
    //     });
    //     console.log(cards);
    // }

    // function displayAssurance(assurances:Array<any>){
    //     assurances.map((a)=>{
    //     });
    // }

    // function getAssurances(nbmois:any) {
    //     console.log('nbmois='+nbmois);
    //     let url=`http://localhost:1234/assurances/expiration/${nbmois}`;
    //     console.log(url);
    //     getData(url,display);
    // }

    console.log(`/assurances/expiration/${nbmois}`);
    var { item, error } = useItems(`/assurances/expiration/${nbmois}`);
    if (item.length == 0)
    {
        return <h1>Waiting...</h1>
    } else
    {
        return (
            <IonPage>
                <IonHeader>
                    <IonToolbar>
                        <IonTitle>Expiration dans moins de {nbmois} moi(s)</IonTitle>
                        <IonButtons slot="start">
                            <IonMenuButton />
                        </IonButtons>
                    </IonToolbar>
                </IonHeader>
                <IonContent fullscreen>
                    {item.map((it: any) =>
                    {
                        return <Assurance avion={it.avion} datepayement={new Date(it.datePayement).toDateString()} dateexpiration={new Date(it.dateExpiration).toISOString()}></Assurance>
                    })}
                </IonContent>
            </IonPage>);
    }


}

export default PageAssurance;
