package jp.co.sunseer.sunseerservice.sunseerprj.service.impl;

import jp.co.sunseer.sunseerservice.sunseerprj.entity.UserInfo;
import jp.co.sunseer.sunseerservice.sunseerprj.mapper.UserInfoMapper;
import jp.co.sunseer.sunseerservice.sunseerprj.service.UserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Group B
 * @since 2021-05-17
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

}
