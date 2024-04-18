package org.example.services;

import org.example.dtos.requests.CreateViewRequest;
import org.example.dtos.requests.FindViewRequest;
import org.example.dtos.responses.CreateViewResponse;
import org.example.dtos.responses.FindViewResponse;

public interface ViewService {

    CreateViewResponse createView(CreateViewRequest createViewRequest);

    FindViewResponse findView(FindViewRequest findViewRequest);


}
