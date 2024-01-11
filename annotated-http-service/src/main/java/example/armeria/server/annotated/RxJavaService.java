package example.armeria.server.annotated;

import com.linecorp.armeria.common.HttpResponse;
import com.linecorp.armeria.common.HttpStatus;
import com.linecorp.armeria.server.annotation.Get;
import com.linecorp.armeria.server.annotation.HttpResult;
import com.linecorp.armeria.server.annotation.ProducesJson;

import io.reactivex.rxjava3.core.Single;

@ProducesJson
public class RxJavaService {
    @Get("/rx-http-response")
    public Single<HttpResponse> getRxHttpResponse() {
        return Single.just(HttpResponse.ofJson(HttpStatus.OK, 123));
    }

    // Does not work
    @Get("/rx-http-result")
    public Single<HttpResult<Integer>> getRxHttpResult() {
        return Single.just(HttpResult.of(HttpStatus.OK, 123));
    }

    @Get("/http-response")
    public HttpResponse getHttpResponse() {
        return HttpResponse.ofJson(HttpStatus.OK, 123);
    }

    @Get("/http-result")
    public HttpResult<Integer> getHttpResult() {
        return HttpResult.of(HttpStatus.OK, 123);
    }
}
