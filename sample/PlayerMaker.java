package sample;

import javafx.scene.image.Image;


public class PlayerMaker {

    public static Image setImage(String image) {

        switch (image) {
            case "Efis":
                return ConstantsThings.PlayerImage.Efis;
            case "EfisFace":
                return ConstantsThings.PlayerImage.EfisFace;

            case "Chara":
                return ConstantsThings.PlayerImage.Chara;
            case "CharaFace":
                return ConstantsThings.PlayerImage.CharaFace;

            case "Brune":
                return ConstantsThings.PlayerImage.Brune;
            case "BruneFace":
                return ConstantsThings.PlayerImage.BruneFace;

            case "Fira":
                return ConstantsThings.PlayerImage.Fira;
            case "FiaraFace":
                return ConstantsThings.PlayerImage.FiaraFace;

            case "Ufrik":
                return ConstantsThings.PlayerImage.Ufrik;
            case "UfrikFace":
                return ConstantsThings.PlayerImage.UfrikFace;

            case "Acri":
                return ConstantsThings.PlayerImage.Acri;
            case "AcriFace":
                return ConstantsThings.PlayerImage.AcriFace;

            case "Clerine":
                return ConstantsThings.PlayerImage.Clerine;
            case "ClerineFace":
                return ConstantsThings.PlayerImage.ClerineFace;

            case "Kienor":
                return ConstantsThings.PlayerImage.Kienor;
            case "KienorFace":
                return ConstantsThings.PlayerImage.KienorFace;

            default:
                return null;
        }
    }
}
