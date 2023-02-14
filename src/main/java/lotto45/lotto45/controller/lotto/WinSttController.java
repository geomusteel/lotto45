package lotto45.lotto45.controller.lotto;

import lombok.RequiredArgsConstructor;
import lotto45.lotto45.service.lotto.IWinSttService;
import lotto45.lotto45.service.lotto.WinSttInfoDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class WinSttController {

    private final IWinSttService winSttService;

    /**
     * <p>LottoWin 정보를 전부 다 빼내어서 비교해 어느 회차의 1~3위 번호였는지 정보를 표시해주는 컨트롤러</p>
     * <p>검증으로는 6개의 숫자 1~ 45인 범위 + 6개를 set에 집어넣었을 때 크기가 6이여야하는 검증 조건이 있고</p>
     * <p>오직 로그인한 회원만 해당 기능을 사용하게 만듬</p>
     * <p>따라서 로그인 후 해당 컨트롤러에 접근할 수 있고 1~3위 로직은 따로 서비스로 구현</p>
     */
    @GetMapping("/WinSttCheck")
    public String saveWinSttForm(@ModelAttribute("form") LottoNumsSaveForm form) {
        return "lotto/saveWinSttForm";
    }

    @PostMapping("/WinSttCheck")
    public String checkLottoNumber(LottoNumsSaveForm form, Model model) {

        List<Integer> lottoNums = new ArrayList<>();
        lottoNums.add(form.getNum1());
        lottoNums.add(form.getNum2());
        lottoNums.add(form.getNum3());
        lottoNums.add(form.getNum4());
        lottoNums.add(form.getNum5());
        lottoNums.add(form.getNum6());

        List<WinSttInfoDTO> winSttInfoDTOS = this.winSttService.calculateSttInfo(lottoNums);

        if (winSttInfoDTOS.size() == 0) {
            model.addAttribute("noWinStt", "당첨 통계가 없습니다.");
        } else {
            model.addAttribute("winSttS", winSttInfoDTOS);
        }

        return "lotto/checkWinStt";
    }
}