package prs.fltoshi.library_clientv2.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class BaseResponse {
    protected Boolean success;
    protected String message;
}
