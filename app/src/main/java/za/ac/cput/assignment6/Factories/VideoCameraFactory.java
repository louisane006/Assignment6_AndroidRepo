package za.ac.cput.assignment6.Factories;

import za.ac.cput.assignment6.Domain.VideoCamera;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class  VideoCameraFactory {
    public static VideoCamera vc(Long i, String n, String cd, double p){
        return new VideoCamera.Builder()
                .id(i)
                .name(n)
                .code(cd)
                .costPrice(p)
                .build();
    }
}

