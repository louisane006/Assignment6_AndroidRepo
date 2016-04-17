package za.ac.cput.assignment6.Factories.Impl;

import java.util.UUID;

import za.ac.cput.assignment6.Domain.VideoCamera;
import za.ac.cput.assignment6.Factories.VideoCameraFactory;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public class VideoCameraFactoryImpl implements VideoCameraFactory {
    private static VideoCameraFactoryImpl factory = null;

    private  VideoCameraFactoryImpl() {
    }
    public static VideoCameraFactoryImpl getInstance(){
        if(factory == null)
            factory = new VideoCameraFactoryImpl();
        return factory;
    }
    public VideoCamera createVideoCamera(String identification, String name, String code, double price)
    {
        VideoCamera  vc = new VideoCamera.Builder().id(UUID.randomUUID().toString()).name(name).code(code).costPrice(price).build();
        return vc;
    }
}
