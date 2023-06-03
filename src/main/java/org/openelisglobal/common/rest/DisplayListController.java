package org.openelisglobal.common.rest;

import java.util.ArrayList;
import java.util.List;

import org.openelisglobal.common.services.DisplayListService;
import org.openelisglobal.common.services.DisplayListService.ListType;
import org.openelisglobal.common.util.ConfigurationProperties;
import org.openelisglobal.common.util.DateUtil;
import org.openelisglobal.common.util.IdValuePair;
import org.openelisglobal.person.service.PersonService;
import org.openelisglobal.person.valueholder.Person;
import org.openelisglobal.provider.service.ProviderService;
import org.openelisglobal.provider.valueholder.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/rest/")
public class DisplayListController {

    @Autowired
    private ProviderService  providerService;

    @Autowired
    private PersonService personService;

    @GetMapping(value = "displayList/{listType}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<IdValuePair> getDisplayList(@PathVariable DisplayListService.ListType listType) {
        return DisplayListService.getInstance().getList(listType);
    }

    @GetMapping(value = "tests", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<IdValuePair> getTests() {
        return DisplayListService.getInstance().getList(ListType.ALL_TESTS);
    }

    @GetMapping(value = "samples", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<IdValuePair> getSamples() {
        return DisplayListService.getInstance().getList(ListType.SAMPLE_TYPE_ACTIVE);
    }

    @GetMapping(value = "health-regions", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<IdValuePair> getHealthRegions() {
        return DisplayListService.getInstance().getList(ListType.PATIENT_HEALTH_REGIONS);
    }

    @GetMapping(value = "education-list", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<IdValuePair> getEducationList() {
        return DisplayListService.getInstance().getList(ListType.PATIENT_EDUCATION);
    }

    @GetMapping(value = "marital-statuses", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<IdValuePair> getMaritialList() {
        return DisplayListService.getInstance().getList(ListType.PATIENT_MARITAL_STATUS);
    }

    @GetMapping(value = "nationalities", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<IdValuePair> getNationalityList() {
        return DisplayListService.getInstance().getList(ListType.PATIENT_NATIONALITY);
    }

    @GetMapping(value = "programs", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<IdValuePair> getPrograms() {
        return DisplayListService.getInstance().getList(ListType.PROGRAM);
    }

    @GetMapping(value = "dictionaryPrograms", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<IdValuePair> getDictionaryPrograms() {
        return DisplayListService.getInstance().getList(ListType.DICTIONARY_PROGRAM);
    }

    @GetMapping(value = "patientPaymentsOptions", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<IdValuePair> getSamplePatientPaymentOptions() {
        return DisplayListService.getInstance().getList(ListType.SAMPLE_PATIENT_PAYMENT_OPTIONS);
    }

    @GetMapping(value = "testLocationCodes", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<IdValuePair> getTestLocationCodes() {
        return DisplayListService.getInstance().getList(ListType.TEST_LOCATION_CODE);
    }

    @GetMapping(value = "test-rejection-reasons", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<IdValuePair> getTestRejectionReasons() {
        return DisplayListService.getInstance().getList(ListType.REJECTION_REASONS);
    }

    @GetMapping(value = "referral-reasons", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    private List<IdValuePair> createReferralReasonList() {
        return DisplayListService.getInstance().getList(ListType.REFERRAL_REASONS);
    }

    @GetMapping(value = "referral-organizations", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    private List<IdValuePair> createReferralOrganizationsList() {
        return DisplayListService.getInstance().getList(ListType.REFERRAL_ORGANIZATIONS);
    }

    @GetMapping(value = "site-names", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    private List<IdValuePair> getSiteNameList() {
        return DisplayListService.getInstance().getList(ListType.SAMPLE_PATIENT_REFERRING_CLINIC);
    }


    @GetMapping(value = "configuration-properties", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    private List<IdValuePair> getConfigurationProperties() {
        ConfigurationProperties.forceReload();

        List<IdValuePair> configs = new ArrayList<>();
	    configs.add(new IdValuePair("restrictFreeTextProviderEntry", ConfigurationProperties.getInstance().getPropertyValue(
			    ConfigurationProperties.Property.restrictFreeTextProviderEntry)));
	    configs.add(new IdValuePair("restrictFreeTextRefSiteEntry", ConfigurationProperties.getInstance().getPropertyValue(
			    ConfigurationProperties.Property.restrictFreeTextRefSiteEntry)));
	    configs.add(new IdValuePair("currentDateAsText", DateUtil.getCurrentDateAsText()));
	    configs.add(new IdValuePair("currentTimeAsText", DateUtil.getCurrentTimeAsText()));
        return configs;
	}

    @GetMapping(value = "practitioner", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    private Provider getProviderInformation(@RequestParam String providerId) {
        if (providerId != null){
            Person person = personService.getPersonById(providerId);
            Provider provider = providerService.getProviderByPerson(person);
            return provider;
        }
        return null;
    }


}
