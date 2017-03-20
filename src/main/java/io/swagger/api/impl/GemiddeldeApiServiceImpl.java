package io.swagger.api.impl;

import com.sun.scenario.effect.InvertMask;
import io.swagger.api.*;
import io.swagger.model.*;

import io.swagger.model.Invoerwaardes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2017-03-16T10:05:48.620Z")
public class GemiddeldeApiServiceImpl extends GemiddeldeApiService {
    public int calculateAverage(Invoerwaardes gemiddelde) {
        int sum = 0;
        int i = 0;
        for (i = 0; i < gemiddelde.size(); i++) {
            sum += gemiddelde.get(i);
        }
        int average = sum / gemiddelde.size();
        return average;
    }

    public  double getVariance(Invoerwaardes gemiddelde) {
        double mean = calculateAverage(gemiddelde);
        double temp = 0;
        for (double a : gemiddelde)
            temp += (a - mean) * (a - mean);
        return temp / gemiddelde.size();
    }

    public double getStdDev(Invoerwaardes gemiddelde)
    {
        return Math.sqrt(getVariance(gemiddelde));
    }

    public double median(Invoerwaardes gemiddelde)
    {
        Collections.sort(gemiddelde);

        if (gemiddelde.size() % 2 == 0)
        {
            return (gemiddelde.get((gemiddelde.size() / 2) - 1) + gemiddelde.get(gemiddelde.size() / 2)) / 2.0;
        }
        return gemiddelde.get(gemiddelde.size() / 2);
    }

    @Override
    public Response gemiddeldePost(Invoerwaardes gemiddelde, SecurityContext securityContext) throws NotFoundException {

        int finalaverage = calculateAverage(gemiddelde);
        String standardDeviation = "The average of the given Array is: "+ calculateAverage(gemiddelde) +", the variance is: "+ getVariance(gemiddelde)+". "
                + "the standard deviation of the given array is: "+ getStdDev(gemiddelde) + ", and finally the median is: "+ median(gemiddelde);
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, standardDeviation)).build();
    }
}
