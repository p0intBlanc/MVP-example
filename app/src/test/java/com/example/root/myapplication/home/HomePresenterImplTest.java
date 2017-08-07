package com.example.root.myapplication.home;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;

import okhttp3.Protocol;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by root on 8/6/17.
 */

@RunWith(MockitoJUnitRunner.class)
public class HomePresenterImplTest {

    @InjectMocks
    private HomePresenterImpl presenter;
    @Mock
    private HomeInteractor interactor;
    @Mock
    private HomeView mView;
    @Mock
    FoodApiInterface apiInterface;

    @Captor
    ArgumentCaptor<Callback<ArrayList<Food>>> argsCaptor;


    @Before
    public void setUp() throws Exception {


    }

    @Test
    public void fetchFoodItemsHappyFlow() throws Exception {
        presenter.fetchFoodItems();
        Mockito.verify(interactor).getFoodItemList(argsCaptor.capture());
        ArrayList<Food> items = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            items.add(new Food());
        }

        final Response<ArrayList<Food>> response = Response.success(items, new okhttp3.Response.Builder() //
                .code(200)
                .message("OK")
                .protocol(Protocol.HTTP_1_1)

                .request(new Request.Builder().url("http://localhost/").build())
                .build());

        argsCaptor.getValue().onResponse(null, response);

        Mockito.verify(mView).showFoodList(items);
    }


    @Test
    public void fetchFoodItemsFailureFlow() throws Exception {
        presenter.fetchFoodItems();
        Mockito.verify(interactor).getFoodItemList(argsCaptor.capture());
        ArrayList<Food> items = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            items.add(new Food());
        }

        argsCaptor.getValue().onFailure(null, null);

        Mockito.verify(mView).showEmptyView();
    }

    @Test
    public void attachView() throws Exception {

    }

    @Test
    public void detachView() throws Exception {

    }

}