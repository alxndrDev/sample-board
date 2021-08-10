package me.alxndr.sampleboard.member;

import lombok.*;

/**
 * @author : Alexander Choi
 * @date : 2021/08/10
 */
@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {

    private Long id;

    private String username;

    private String password;

}
