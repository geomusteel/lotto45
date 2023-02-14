package lotto45.lotto45.controller.lotto;

import lombok.RequiredArgsConstructor;
import lotto45.lotto45.domain.lotto.Lotto;
import lotto45.lotto45.service.lotto.LottoNumberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class LottoNumberController {

    private final LottoNumberService lottoNumberService;

    @GetMapping("/lotto45")
    public String newLottoNumber(Model model){
        Lotto lotto = lottoNumberService.create();
        List<Lotto> last8Numbers = lottoNumberService.lastLottoNumber8();
        model.addAttribute("lotto", lotto);
        model.addAttribute("last8Numbers",last8Numbers);
        return "lotto/lotto45main";
    }

}
