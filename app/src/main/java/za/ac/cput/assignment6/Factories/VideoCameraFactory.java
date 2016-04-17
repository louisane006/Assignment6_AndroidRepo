package za.ac.cput.assignment6.Factories;

import za.ac.cput.assignment6.Domain.VideoCamera;

/**
 * Created by louisane Malu on 4/2/2016.
 */
public interface  VideoCameraFactory {
    VideoCamera createVideoCamera(String identification, String name, String code, double price);
}

