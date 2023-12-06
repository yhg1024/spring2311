package models.member;

public class ServiceManager {

    // 최초의 한번은 null값이고 나중엔 공유한다.
    private static ServiceManager instance = null;

    private ServiceManager() {

    }

    public static ServiceManager getInstance() {
        // 최초의 한번 공유
        if(instance == null) {
            instance = new ServiceManager();
        }
        return instance;
    }

    // 객체를 조립할때 필요한 하나의 구성요소
    public MemberDao memberDao() {
        return new MemberDao();
    }

    public JoinValidator joinValidator() {
        return new JoinValidator(memberDao());
    }

    public JoinService joinService() {
        return new JoinService(memberDao(), joinValidator());
    }

    public ListService listService() {
        ListService listService = new ListService();
        listService.setMemberDao(memberDao());

        return listService;
    }
}
