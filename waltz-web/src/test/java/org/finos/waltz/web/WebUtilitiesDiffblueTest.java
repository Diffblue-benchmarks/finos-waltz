package org.finos.waltz.web;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.awt.Component;
import java.awt.Component.BaselineResizeBehavior;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import org.finos.waltz.data.EntityReferenceNameResolver;
import org.finos.waltz.data.application.ApplicationDao;
import org.finos.waltz.data.changelog.ChangeLogDao;
import org.finos.waltz.data.changelog.ChangeLogSummariesDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.data.measurable_rating.MeasurableRatingDao;
import org.finos.waltz.data.measurable_rating_planned_decommission.MeasurableRatingPlannedDecommissionDao;
import org.finos.waltz.data.measurable_rating_replacement.MeasurableRatingReplacementDao;
import org.finos.waltz.data.person.PersonDao;
import org.finos.waltz.data.person.search.PersonSearchDao;
import org.finos.waltz.data.physical_flow.PhysicalFlowDao;
import org.finos.waltz.data.physical_specification.PhysicalSpecificationDao;
import org.finos.waltz.data.role.RoleDao;
import org.finos.waltz.data.settings.SettingsDao;
import org.finos.waltz.data.user.UserRoleDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.Entry;
import org.finos.waltz.model.ImmutableEntry;
import org.finos.waltz.model.Operation;
import org.finos.waltz.model.settings.ImmutableSetting;
import org.finos.waltz.model.settings.Setting;
import org.finos.waltz.model.user.SystemRole;
import org.finos.waltz.service.changelog.ChangeLogService;
import org.finos.waltz.service.person.PersonService;
import org.finos.waltz.service.settings.SettingsService;
import org.finos.waltz.service.user.UserRoleService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.event.EventRecordingLogger;
import org.slf4j.helpers.SubstituteLogger;
import org.springframework.mock.web.MockHttpServletRequest;
import spark.Request;
import spark.RequestResponseFactory;
import spark.Response;

class WebUtilitiesDiffblueTest {
  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath(
            "Cannot convert empty or null segments to path",
            "Cannot convert empty or null segments to path",
            "/");

    // Assert
    assertEquals(
        "Cannot convert empty or null segments to path/Cannot convert empty or null segments to path/",
        actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath2() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath(
            "Predicate must be provided", "Cannot convert empty or null segments to path", "/");

    // Assert
    assertEquals(
        "Predicate must be provided/Cannot convert empty or null segments to path/",
        actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath3() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath(
            "/",
            "Cannot convert empty or null segments to path",
            "Cannot convert empty or null segments to path");

    // Assert
    assertEquals(
        "/Cannot convert empty or null segments to path/Cannot convert empty or null segments to path",
        actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath4() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath(
            "/", "Cannot convert empty or null segments to path", "Predicate must be provided");

    // Assert
    assertEquals(
        "/Cannot convert empty or null segments to path/Predicate must be provided",
        actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath5() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath(
            "Cannot convert empty or null segments to path", "Predicate must be provided", "/");

    // Assert
    assertEquals(
        "Cannot convert empty or null segments to path/Predicate must be provided/",
        actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath6() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath(
            "Cannot convert empty or null segments to path",
            "Cannot convert empty or null segments to path",
            "/+");

    // Assert
    assertEquals(
        "Cannot convert empty or null segments to path/Cannot convert empty or null segments to path/+",
        actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath7() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath(
            "Predicate must be provided", "Cannot convert empty or null segments to path", "/+");

    // Assert
    assertEquals(
        "Predicate must be provided/Cannot convert empty or null segments to path/+",
        actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath8() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath(
            "/", "Predicate must be provided", "Cannot convert empty or null segments to path");

    // Assert
    assertEquals(
        "/Predicate must be provided/Cannot convert empty or null segments to path",
        actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath9() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath(
            "Cannot convert empty or null segments to path",
            "/",
            "Cannot convert empty or null segments to path");

    // Assert
    assertEquals(
        "Cannot convert empty or null segments to path/Cannot convert empty or null segments to path",
        actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath10() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath(
            "Cannot convert empty or null segments to path", "/", "Predicate must be provided");

    // Assert
    assertEquals(
        "Cannot convert empty or null segments to path/Predicate must be provided",
        actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath11() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath(
            "Cannot convert empty or null segments to path", "Predicate must be provided", "/+");

    // Assert
    assertEquals(
        "Cannot convert empty or null segments to path/Predicate must be provided/+",
        actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code 42/Cannot convert empty or null segments to path/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return '42/Cannot convert empty or null segments to path/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturn42CannotConvertEmptyOrNullSegmentsToPath() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath("42", "Cannot convert empty or null segments to path", "/");

    // Assert
    assertEquals("42/Cannot convert empty or null segments to path/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code 42/Cannot convert empty or null segments to path/+}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return '42/Cannot convert empty or null segments to path/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturn42CannotConvertEmptyOrNullSegmentsToPath2() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath("42", "Cannot convert empty or null segments to path", "/+");

    // Assert
    assertEquals("42/Cannot convert empty or null segments to path/+", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Array must be provided/Array must be provided/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Array must be provided/Array must be provided/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayMustBeProvidedArrayMustBeProvided() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath("Array must be provided", "Array must be provided", "/");

    // Assert
    assertEquals("Array must be provided/Array must be provided/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /Array must be provided/Array must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return '/Array must be provided/Array must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayMustBeProvidedArrayMustBeProvided2() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath("/", "Array must be provided", "Array must be provided");

    // Assert
    assertEquals("/Array must be provided/Array must be provided", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Array must be provided/: Array was null/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Array must be provided/: Array was null/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayMustBeProvidedArrayWasNull() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath("Array must be provided", ": Array was null", "/");

    // Assert
    assertEquals("Array must be provided/: Array was null/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /Array must be provided/: Array was null}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Array must be provided/: Array was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayMustBeProvidedArrayWasNull2() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath("/", "Array must be provided", ": Array was null");

    // Assert
    assertEquals("/Array must be provided/: Array was null", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Array must be provided/Cannot convert empty or null segments to
   *       path/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Array must be provided/Cannot convert empty or null segments to path/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayMustBeProvidedCannotConvertEmptyOrNullSegmentsToPath() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath(
            "Array must be provided", "Cannot convert empty or null segments to path", "/");

    // Assert
    assertEquals(
        "Array must be provided/Cannot convert empty or null segments to path/",
        actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Array must be provided/Cannot convert empty or null segments to
   *       path/+}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Array must be provided/Cannot convert empty or null segments to path/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayMustBeProvidedCannotConvertEmptyOrNullSegmentsToPath2() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath(
            "Array must be provided", "Cannot convert empty or null segments to path", "/+");

    // Assert
    assertEquals(
        "Array must be provided/Cannot convert empty or null segments to path/+",
        actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /Array must be provided/Cannot convert empty or null segments to
   *       path}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return '/Array must be provided/Cannot convert empty or null segments to path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayMustBeProvidedCannotConvertEmptyOrNullSegmentsToPath3() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath(
            "/", "Array must be provided", "Cannot convert empty or null segments to path");

    // Assert
    assertEquals(
        "/Array must be provided/Cannot convert empty or null segments to path",
        actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Array must be provided/Predicate must be provided/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Array must be provided/Predicate must be provided/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayMustBeProvidedPredicateMustBeProvided() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath("Array must be provided", "Predicate must be provided", "/");

    // Assert
    assertEquals("Array must be provided/Predicate must be provided/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /Array must be provided/Predicate must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return '/Array must be provided/Predicate must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayMustBeProvidedPredicateMustBeProvided2() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath("/", "Array must be provided", "Predicate must be provided");

    // Assert
    assertEquals("/Array must be provided/Predicate must be provided", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Array must be provided/: Predicate was null/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Array must be provided/: Predicate was null/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayMustBeProvidedPredicateWasNull() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath("Array must be provided", ": Predicate was null", "/");

    // Assert
    assertEquals("Array must be provided/: Predicate was null/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /Array must be provided/: Predicate was null}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Array must be provided/: Predicate was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayMustBeProvidedPredicateWasNull2() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath("/", "Array must be provided", ": Predicate was null");

    // Assert
    assertEquals("/Array must be provided/: Predicate was null", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Array must be provided/yyyy-MM-dd/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Array must be provided/yyyy-MM-dd/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayMustBeProvidedYyyyMmDd() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("Array must be provided", "yyyy-MM-dd", "/");

    // Assert
    assertEquals("Array must be provided/yyyy-MM-dd/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code : Array was null/Array must be provided/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return ': Array was null/Array must be provided/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayWasNullArrayMustBeProvided() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath(": Array was null", "Array must be provided", "/");

    // Assert
    assertEquals(": Array was null/Array must be provided/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code : Array was null/Cannot convert empty or null segments to path/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return ': Array was null/Cannot convert empty or null segments to path/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayWasNullCannotConvertEmptyOrNullSegmentsToPath() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath(
            ": Array was null", "Cannot convert empty or null segments to path", "/");

    // Assert
    assertEquals(
        ": Array was null/Cannot convert empty or null segments to path/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code : Array was null/Cannot convert empty or null segments to path/+}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return ': Array was null/Cannot convert empty or null segments to path/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayWasNullCannotConvertEmptyOrNullSegmentsToPath2() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath(
            ": Array was null", "Cannot convert empty or null segments to path", "/+");

    // Assert
    assertEquals(
        ": Array was null/Cannot convert empty or null segments to path/+", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /: Array was null/Cannot convert empty or null segments to path}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return '/: Array was null/Cannot convert empty or null segments to path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayWasNullCannotConvertEmptyOrNullSegmentsToPath3() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath(
            "/", ": Array was null", "Cannot convert empty or null segments to path");

    // Assert
    assertEquals(
        "/: Array was null/Cannot convert empty or null segments to path", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code : Array was null/Predicate must be provided/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return ': Array was null/Predicate must be provided/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayWasNullPredicateMustBeProvided() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath(": Array was null", "Predicate must be provided", "/");

    // Assert
    assertEquals(": Array was null/Predicate must be provided/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /: Array was null/Predicate must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/: Array was null/Predicate must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayWasNullPredicateMustBeProvided2() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath("/", ": Array was null", "Predicate must be provided");

    // Assert
    assertEquals("/: Array was null/Predicate must be provided", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code : Array was null/: Predicate was null/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return ': Array was null/: Predicate was null/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayWasNullPredicateWasNull() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath(": Array was null", ": Predicate was null", "/");

    // Assert
    assertEquals(": Array was null/: Predicate was null/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /Cannot convert empty or null segments to path}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return '/Cannot convert empty or null segments to path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPath() {
    // Arrange, Act and Assert
    assertEquals(
        "/Cannot convert empty or null segments to path",
        WebUtilities.mkPath("/", "Cannot convert empty or null segments to path"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /Cannot convert empty or null segments to path/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return '/Cannot convert empty or null segments to path/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPath2() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath("/", "Cannot convert empty or null segments to path", "/");

    // Assert
    assertEquals("/Cannot convert empty or null segments to path/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /+/Cannot convert empty or null segments to path/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return '/+/Cannot convert empty or null segments to path/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPath3() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath("/+", "Cannot convert empty or null segments to path", "/");

    // Assert
    assertEquals("/+/Cannot convert empty or null segments to path/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /Cannot convert empty or null segments to path/+}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return '/Cannot convert empty or null segments to path/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPath4() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath("/", "Cannot convert empty or null segments to path", "/+");

    // Assert
    assertEquals("/Cannot convert empty or null segments to path/+", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPath5() {
    // Arrange, Act and Assert
    assertEquals(
        "Cannot convert empty or null segments to path/",
        WebUtilities.mkPath("Cannot convert empty or null segments to path", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/+}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPath6() {
    // Arrange, Act and Assert
    assertEquals(
        "Cannot convert empty or null segments to path/+",
        WebUtilities.mkPath("Cannot convert empty or null segments to path", "/+"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPath7() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath("Cannot convert empty or null segments to path", "/", "/");

    // Assert
    assertEquals("Cannot convert empty or null segments to path/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/+/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/+/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPath8() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath("Cannot convert empty or null segments to path", "/+", "/");

    // Assert
    assertEquals("Cannot convert empty or null segments to path/+/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /+/Cannot convert empty or null segments to path/+}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return '/+/Cannot convert empty or null segments to path/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPath9() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath("/+", "Cannot convert empty or null segments to path", "/+");

    // Assert
    assertEquals("/+/Cannot convert empty or null segments to path/+", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /+/Cannot convert empty or null segments to path}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return '/+/Cannot convert empty or null segments to path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPath10() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath("/", "/+", "Cannot convert empty or null segments to path");

    // Assert
    assertEquals("/+/Cannot convert empty or null segments to path", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/+}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPath11() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath("Cannot convert empty or null segments to path", "/", "/+");

    // Assert
    assertEquals("Cannot convert empty or null segments to path/+", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /Cannot convert empty or null segments to path/42}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return '/Cannot convert empty or null segments to path/42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPath42() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath("/", "Cannot convert empty or null segments to path", "42");

    // Assert
    assertEquals("/Cannot convert empty or null segments to path/42", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/42/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/42/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPath422() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath("Cannot convert empty or null segments to path", "42", "/");

    // Assert
    assertEquals("Cannot convert empty or null segments to path/42/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/42}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPath423() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath("Cannot convert empty or null segments to path", "/", "42");

    // Assert
    assertEquals("Cannot convert empty or null segments to path/42", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /Cannot convert empty or null segments to path/Array must be
   *       provided}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return '/Cannot convert empty or null segments to path/Array must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathArrayMustBeProvided() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath(
            "/", "Cannot convert empty or null segments to path", "Array must be provided");

    // Assert
    assertEquals(
        "/Cannot convert empty or null segments to path/Array must be provided",
        actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/Array must be
   *       provided/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/Array must be provided/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathArrayMustBeProvided2() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath(
            "Cannot convert empty or null segments to path", "Array must be provided", "/");

    // Assert
    assertEquals(
        "Cannot convert empty or null segments to path/Array must be provided/",
        actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/Array must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/Array must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathArrayMustBeProvided3() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath(
            "Cannot convert empty or null segments to path", "/", "Array must be provided");

    // Assert
    assertEquals(
        "Cannot convert empty or null segments to path/Array must be provided", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/Array must be
   *       provided/+}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/Array must be provided/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathArrayMustBeProvided4() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath(
            "Cannot convert empty or null segments to path", "Array must be provided", "/+");

    // Assert
    assertEquals(
        "Cannot convert empty or null segments to path/Array must be provided/+",
        actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /Cannot convert empty or null segments to path/: Array was null}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return '/Cannot convert empty or null segments to path/: Array was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathArrayWasNull() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath(
            "/", "Cannot convert empty or null segments to path", ": Array was null");

    // Assert
    assertEquals(
        "/Cannot convert empty or null segments to path/: Array was null", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/: Array was null/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/: Array was null/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathArrayWasNull2() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath(
            "Cannot convert empty or null segments to path", ": Array was null", "/");

    // Assert
    assertEquals(
        "Cannot convert empty or null segments to path/: Array was null/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/: Array was null}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/: Array was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathArrayWasNull3() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath(
            "Cannot convert empty or null segments to path", "/", ": Array was null");

    // Assert
    assertEquals(
        "Cannot convert empty or null segments to path/: Array was null", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/: Array was null/+}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/: Array was null/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathArrayWasNull4() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath(
            "Cannot convert empty or null segments to path", ": Array was null", "/+");

    // Assert
    assertEquals(
        "Cannot convert empty or null segments to path/: Array was null/+", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /Cannot convert empty or null segments to path/: Predicate was null}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return '/Cannot convert empty or null segments to path/: Predicate was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathPredicateWasNull() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath(
            "/", "Cannot convert empty or null segments to path", ": Predicate was null");

    // Assert
    assertEquals(
        "/Cannot convert empty or null segments to path/: Predicate was null", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/: Predicate was null/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/: Predicate was null/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathPredicateWasNull2() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath(
            "Cannot convert empty or null segments to path", ": Predicate was null", "/");

    // Assert
    assertEquals(
        "Cannot convert empty or null segments to path/: Predicate was null/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/: Predicate was null}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/: Predicate was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathPredicateWasNull3() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath(
            "Cannot convert empty or null segments to path", "/", ": Predicate was null");

    // Assert
    assertEquals(
        "Cannot convert empty or null segments to path/: Predicate was null", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/: Predicate was null/+}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/: Predicate was null/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathPredicateWasNull4() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath(
            "Cannot convert empty or null segments to path", ": Predicate was null", "/+");

    // Assert
    assertEquals(
        "Cannot convert empty or null segments to path/: Predicate was null/+", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /Cannot convert empty or null segments to path/Segs}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return '/Cannot convert empty or null segments to path/Segs'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathSegs() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath("/", "Cannot convert empty or null segments to path", "Segs");

    // Assert
    assertEquals("/Cannot convert empty or null segments to path/Segs", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/Segs/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/Segs/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathSegs2() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath("Cannot convert empty or null segments to path", "Segs", "/");

    // Assert
    assertEquals("Cannot convert empty or null segments to path/Segs/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/Segs}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/Segs'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathSegs3() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath("Cannot convert empty or null segments to path", "/", "Segs");

    // Assert
    assertEquals("Cannot convert empty or null segments to path/Segs", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /Cannot convert empty or null segments to path/ttf}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return '/Cannot convert empty or null segments to path/ttf'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathTtf() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath("/", "Cannot convert empty or null segments to path", "ttf");

    // Assert
    assertEquals("/Cannot convert empty or null segments to path/ttf", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/ttf/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/ttf/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathTtf2() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath("Cannot convert empty or null segments to path", "ttf", "/");

    // Assert
    assertEquals("Cannot convert empty or null segments to path/ttf/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/ttf}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/ttf'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathTtf3() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath("Cannot convert empty or null segments to path", "/", "ttf");

    // Assert
    assertEquals("Cannot convert empty or null segments to path/ttf", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /Cannot convert empty or null segments to path/yyyy-MM-dd}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return '/Cannot convert empty or null segments to path/yyyy-MM-dd'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathYyyyMmDd() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath("/", "Cannot convert empty or null segments to path", "yyyy-MM-dd");

    // Assert
    assertEquals("/Cannot convert empty or null segments to path/yyyy-MM-dd", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/yyyy-MM-dd/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/yyyy-MM-dd/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathYyyyMmDd2() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath("Cannot convert empty or null segments to path", "yyyy-MM-dd", "/");

    // Assert
    assertEquals("Cannot convert empty or null segments to path/yyyy-MM-dd/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/yyyy-MM-dd}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/yyyy-MM-dd'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathYyyyMmDd3() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath("Cannot convert empty or null segments to path", "/", "yyyy-MM-dd");

    // Assert
    assertEquals("Cannot convert empty or null segments to path/yyyy-MM-dd", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Predicate must be provided/+}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Predicate must be provided/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals(
        "Predicate must be provided/+", WebUtilities.mkPath("Predicate must be provided", "/+"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Predicate must be provided/+/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Predicate must be provided/+/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvided2() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("Predicate must be provided", "/+", "/");

    // Assert
    assertEquals("Predicate must be provided/+/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /+/Predicate must be provided/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/+/Predicate must be provided/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvided3() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/+", "Predicate must be provided", "/");

    // Assert
    assertEquals("/+/Predicate must be provided/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /Predicate must be provided/42}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Predicate must be provided/42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvided42() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "Predicate must be provided", "42");

    // Assert
    assertEquals("/Predicate must be provided/42", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Predicate must be provided/Array must be provided/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Predicate must be provided/Array must be provided/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvidedArrayMustBeProvided() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath("Predicate must be provided", "Array must be provided", "/");

    // Assert
    assertEquals("Predicate must be provided/Array must be provided/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /Predicate must be provided/Array must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return '/Predicate must be provided/Array must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvidedArrayMustBeProvided2() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath("/", "Predicate must be provided", "Array must be provided");

    // Assert
    assertEquals("/Predicate must be provided/Array must be provided", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Predicate must be provided/: Array was null/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Predicate must be provided/: Array was null/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvidedArrayWasNull() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath("Predicate must be provided", ": Array was null", "/");

    // Assert
    assertEquals("Predicate must be provided/: Array was null/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /Predicate must be provided/: Array was null}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Predicate must be provided/: Array was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvidedArrayWasNull2() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath("/", "Predicate must be provided", ": Array was null");

    // Assert
    assertEquals("/Predicate must be provided/: Array was null", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Predicate must be provided/Predicate must be provided/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Predicate must be provided/Predicate must be provided/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvidedPredicateMustBeProvided() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath("Predicate must be provided", "Predicate must be provided", "/");

    // Assert
    assertEquals("Predicate must be provided/Predicate must be provided/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /Predicate must be provided/Predicate must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return '/Predicate must be provided/Predicate must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvidedPredicateMustBeProvided2() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath("/", "Predicate must be provided", "Predicate must be provided");

    // Assert
    assertEquals("/Predicate must be provided/Predicate must be provided", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Predicate must be provided/: Predicate was null/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Predicate must be provided/: Predicate was null/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvidedPredicateWasNull() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath("Predicate must be provided", ": Predicate was null", "/");

    // Assert
    assertEquals("Predicate must be provided/: Predicate was null/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /Predicate must be provided/: Predicate was null}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return '/Predicate must be provided/: Predicate was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvidedPredicateWasNull2() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath("/", "Predicate must be provided", ": Predicate was null");

    // Assert
    assertEquals("/Predicate must be provided/: Predicate was null", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Predicate must be provided/Segs/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Predicate must be provided/Segs/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvidedSegs() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("Predicate must be provided", "Segs", "/");

    // Assert
    assertEquals("Predicate must be provided/Segs/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /Predicate must be provided/Segs}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Predicate must be provided/Segs'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvidedSegs2() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "Predicate must be provided", "Segs");

    // Assert
    assertEquals("/Predicate must be provided/Segs", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Predicate must be provided/ttf/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Predicate must be provided/ttf/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvidedTtf() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("Predicate must be provided", "ttf", "/");

    // Assert
    assertEquals("Predicate must be provided/ttf/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /Predicate must be provided/ttf}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Predicate must be provided/ttf'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvidedTtf2() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "Predicate must be provided", "ttf");

    // Assert
    assertEquals("/Predicate must be provided/ttf", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Predicate must be provided/yyyy-MM-dd/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Predicate must be provided/yyyy-MM-dd/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvidedYyyyMmDd() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath("Predicate must be provided", "yyyy-MM-dd", "/");

    // Assert
    assertEquals("Predicate must be provided/yyyy-MM-dd/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /Predicate must be provided/yyyy-MM-dd}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Predicate must be provided/yyyy-MM-dd'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvidedYyyyMmDd2() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath("/", "Predicate must be provided", "yyyy-MM-dd");

    // Assert
    assertEquals("/Predicate must be provided/yyyy-MM-dd", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code : Predicate was null/Array must be provided/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return ': Predicate was null/Array must be provided/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateWasNullArrayMustBeProvided() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath(": Predicate was null", "Array must be provided", "/");

    // Assert
    assertEquals(": Predicate was null/Array must be provided/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /: Predicate was null/Array must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/: Predicate was null/Array must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateWasNullArrayMustBeProvided2() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath("/", ": Predicate was null", "Array must be provided");

    // Assert
    assertEquals("/: Predicate was null/Array must be provided", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code : Predicate was null/: Array was null/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return ': Predicate was null/: Array was null/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateWasNullArrayWasNull() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath(": Predicate was null", ": Array was null", "/");

    // Assert
    assertEquals(": Predicate was null/: Array was null/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code : Predicate was null/Cannot convert empty or null segments to path/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return ': Predicate was null/Cannot convert empty or null segments to path/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateWasNullCannotConvertEmptyOrNullSegmentsToPath() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath(
            ": Predicate was null", "Cannot convert empty or null segments to path", "/");

    // Assert
    assertEquals(
        ": Predicate was null/Cannot convert empty or null segments to path/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code : Predicate was null/Cannot convert empty or null segments to path/+}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return ': Predicate was null/Cannot convert empty or null segments to path/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateWasNullCannotConvertEmptyOrNullSegmentsToPath2() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath(
            ": Predicate was null", "Cannot convert empty or null segments to path", "/+");

    // Assert
    assertEquals(
        ": Predicate was null/Cannot convert empty or null segments to path/+", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /: Predicate was null/Cannot convert empty or null segments to path}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return '/: Predicate was null/Cannot convert empty or null segments to path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateWasNullCannotConvertEmptyOrNullSegmentsToPath3() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath(
            "/", ": Predicate was null", "Cannot convert empty or null segments to path");

    // Assert
    assertEquals(
        "/: Predicate was null/Cannot convert empty or null segments to path", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code : Predicate was null/Predicate must be provided/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return ': Predicate was null/Predicate must be provided/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateWasNullPredicateMustBeProvided() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath(": Predicate was null", "Predicate must be provided", "/");

    // Assert
    assertEquals(": Predicate was null/Predicate must be provided/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /: Predicate was null/Predicate must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return '/: Predicate was null/Predicate must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateWasNullPredicateMustBeProvided2() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath("/", ": Predicate was null", "Predicate must be provided");

    // Assert
    assertEquals("/: Predicate was null/Predicate must be provided", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code : Predicate was null/: Predicate was null/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return ': Predicate was null/: Predicate was null/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateWasNullPredicateWasNull() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath(": Predicate was null", ": Predicate was null", "/");

    // Assert
    assertEquals(": Predicate was null/: Predicate was null/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /: Predicate was null/: Predicate was null}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/: Predicate was null/: Predicate was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateWasNullPredicateWasNull2() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath("/", ": Predicate was null", ": Predicate was null");

    // Assert
    assertEquals("/: Predicate was null/: Predicate was null", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Segs/Cannot convert empty or null segments to path/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Segs/Cannot convert empty or null segments to path/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnSegsCannotConvertEmptyOrNullSegmentsToPath() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath("Segs", "Cannot convert empty or null segments to path", "/");

    // Assert
    assertEquals("Segs/Cannot convert empty or null segments to path/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Segs/Cannot convert empty or null segments to path/+}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'Segs/Cannot convert empty or null segments to path/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnSegsCannotConvertEmptyOrNullSegmentsToPath2() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath("Segs", "Cannot convert empty or null segments to path", "/+");

    // Assert
    assertEquals("Segs/Cannot convert empty or null segments to path/+", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code Segs/Predicate must be provided/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Segs/Predicate must be provided/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnSegsPredicateMustBeProvided() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("Segs", "Predicate must be provided", "/");

    // Assert
    assertEquals("Segs/Predicate must be provided/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /+/+}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/+/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnSlashPlusSignSlashPlusSign() {
    // Arrange, Act and Assert
    assertEquals("/+/+", WebUtilities.mkPath("/+", "/+"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /+/+/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/+/+/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnSlashPlusSignSlashPlusSignSlash() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/+", "/+", "/");

    // Assert
    assertEquals("/+/+/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code ttf/Cannot convert empty or null segments to path/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'ttf/Cannot convert empty or null segments to path/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnTtfCannotConvertEmptyOrNullSegmentsToPath() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath("ttf", "Cannot convert empty or null segments to path", "/");

    // Assert
    assertEquals("ttf/Cannot convert empty or null segments to path/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code ttf/Cannot convert empty or null segments to path/+}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'ttf/Cannot convert empty or null segments to path/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnTtfCannotConvertEmptyOrNullSegmentsToPath2() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath("ttf", "Cannot convert empty or null segments to path", "/+");

    // Assert
    assertEquals("ttf/Cannot convert empty or null segments to path/+", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code ttf/Predicate must be provided/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'ttf/Predicate must be provided/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnTtfPredicateMustBeProvided() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("ttf", "Predicate must be provided", "/");

    // Assert
    assertEquals("ttf/Predicate must be provided/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code yyyy-MM-dd/Array must be provided/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'yyyy-MM-dd/Array must be provided/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnYyyyMmDdArrayMustBeProvided() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("yyyy-MM-dd", "Array must be provided", "/");

    // Assert
    assertEquals("yyyy-MM-dd/Array must be provided/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code yyyy-MM-dd/Cannot convert empty or null segments to path/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'yyyy-MM-dd/Cannot convert empty or null segments to path/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnYyyyMmDdCannotConvertEmptyOrNullSegmentsToPath() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath("yyyy-MM-dd", "Cannot convert empty or null segments to path", "/");

    // Assert
    assertEquals("yyyy-MM-dd/Cannot convert empty or null segments to path/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code /yyyy-MM-dd/Cannot convert empty or null segments to path}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return '/yyyy-MM-dd/Cannot convert empty or null segments to path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnYyyyMmDdCannotConvertEmptyOrNullSegmentsToPath2() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath("/", "yyyy-MM-dd", "Cannot convert empty or null segments to path");

    // Assert
    assertEquals("/yyyy-MM-dd/Cannot convert empty or null segments to path", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code yyyy-MM-dd/Cannot convert empty or null segments to path/+}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); then return 'yyyy-MM-dd/Cannot convert empty or null segments to path/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnYyyyMmDdCannotConvertEmptyOrNullSegmentsToPath3() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath("yyyy-MM-dd", "Cannot convert empty or null segments to path", "/+");

    // Assert
    assertEquals("yyyy-MM-dd/Cannot convert empty or null segments to path/+", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>Then return {@code yyyy-MM-dd/Predicate must be provided/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'yyyy-MM-dd/Predicate must be provided/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnYyyyMmDdPredicateMustBeProvided() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath("yyyy-MM-dd", "Predicate must be provided", "/");

    // Assert
    assertEquals("yyyy-MM-dd/Predicate must be provided/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code 42} and {@code 42}.
   *   <li>Then return {@code 42/42/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '42' and '42'; then return '42/42/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_when42And42_thenReturn4242() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("42", "42", "/");

    // Assert
    assertEquals("42/42/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code 42} and {@code Array must be provided}.
   *   <li>Then return {@code 42/Array must be provided/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '42' and 'Array must be provided'; then return '42/Array must be provided/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_when42AndArrayMustBeProvided_thenReturn42ArrayMustBeProvided() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("42", "Array must be provided", "/");

    // Assert
    assertEquals("42/Array must be provided/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code 42} and {@code : Array was null}.
   *   <li>Then return {@code 42/: Array was null/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '42' and ': Array was null'; then return '42/: Array was null/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_when42AndArrayWasNull_thenReturn42ArrayWasNull() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("42", ": Array was null", "/");

    // Assert
    assertEquals("42/: Array was null/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code 42} and {@code Predicate must be provided}.
   *   <li>Then return {@code 42/Predicate must be provided/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '42' and 'Predicate must be provided'; then return '42/Predicate must be provided/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_when42AndPredicateMustBeProvided_thenReturn42PredicateMustBeProvided() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("42", "Predicate must be provided", "/");

    // Assert
    assertEquals("42/Predicate must be provided/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code 42} and {@code : Predicate was null}.
   *   <li>Then return {@code 42/: Predicate was null/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '42' and ': Predicate was null'; then return '42/: Predicate was null/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_when42AndPredicateWasNull_thenReturn42PredicateWasNull() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("42", ": Predicate was null", "/");

    // Assert
    assertEquals("42/: Predicate was null/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code 42} and {@code Segs}.
   *   <li>Then return {@code 42/Segs/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '42' and 'Segs'; then return '42/Segs/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_when42AndSegs_thenReturn42Segs() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("42", "Segs", "/");

    // Assert
    assertEquals("42/Segs/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code 42} and {@code /+}.
   *   <li>Then return {@code 42/+}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '42' and '/+'; then return '42/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_when42AndSlashPlusSign_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42/+", WebUtilities.mkPath("42", "/+"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code 42} and {@code /+}.
   *   <li>Then return {@code 42/+/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '42' and '/+'; then return '42/+/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_when42AndSlashPlusSign_thenReturn422() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("42", "/+", "/");

    // Assert
    assertEquals("42/+/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code 42} and {@code /}.
   *   <li>Then return {@code 42/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '42' and '/'; then return '42/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_when42AndSlash_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42/", WebUtilities.mkPath("42", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code 42} and {@code /}.
   *   <li>Then return {@code 42/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '42' and '/'; then return '42/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_when42AndSlash_thenReturn422() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("42", "/", "/");

    // Assert
    assertEquals("42/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code 42} and {@code ttf}.
   *   <li>Then return {@code 42/ttf/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '42' and 'ttf'; then return '42/ttf/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_when42AndTtf_thenReturn42Ttf() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("42", "ttf", "/");

    // Assert
    assertEquals("42/ttf/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code 42} and {@code yyyy-MM-dd}.
   *   <li>Then return {@code 42/yyyy-MM-dd/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '42' and 'yyyy-MM-dd'; then return '42/yyyy-MM-dd/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_when42AndYyyyMmDd_thenReturn42YyyyMmDd() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("42", "yyyy-MM-dd", "/");

    // Assert
    assertEquals("42/yyyy-MM-dd/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code Array must be provided} and {@code 42}.
   *   <li>Then return {@code Array must be provided/42/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when 'Array must be provided' and '42'; then return 'Array must be provided/42/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenArrayMustBeProvidedAnd42_thenReturnArrayMustBeProvided42() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("Array must be provided", "42", "/");

    // Assert
    assertEquals("Array must be provided/42/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code Array must be provided} and {@code Segs}.
   *   <li>Then return {@code Array must be provided/Segs/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when 'Array must be provided' and 'Segs'; then return 'Array must be provided/Segs/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenArrayMustBeProvidedAndSegs_thenReturnArrayMustBeProvidedSegs() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("Array must be provided", "Segs", "/");

    // Assert
    assertEquals("Array must be provided/Segs/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code Array must be provided} and {@code /+}.
   *   <li>Then return {@code Array must be provided/+}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when 'Array must be provided' and '/+'; then return 'Array must be provided/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenArrayMustBeProvidedAndSlashPlusSign_thenReturnArrayMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("Array must be provided/+", WebUtilities.mkPath("Array must be provided", "/+"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code Array must be provided} and {@code /+}.
   *   <li>Then return {@code Array must be provided/+/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when 'Array must be provided' and '/+'; then return 'Array must be provided/+/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenArrayMustBeProvidedAndSlashPlusSign_thenReturnArrayMustBeProvided2() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("Array must be provided", "/+", "/");

    // Assert
    assertEquals("Array must be provided/+/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code Array must be provided} and {@code /}.
   *   <li>Then return {@code Array must be provided/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when 'Array must be provided' and '/'; then return 'Array must be provided/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenArrayMustBeProvidedAndSlash_thenReturnArrayMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("Array must be provided/", WebUtilities.mkPath("Array must be provided", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code Array must be provided} and {@code /}.
   *   <li>Then return {@code Array must be provided/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when 'Array must be provided' and '/'; then return 'Array must be provided/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenArrayMustBeProvidedAndSlash_thenReturnArrayMustBeProvided2() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("Array must be provided", "/", "/");

    // Assert
    assertEquals("Array must be provided/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code Array must be provided} and {@code ttf}.
   *   <li>Then return {@code Array must be provided/ttf/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when 'Array must be provided' and 'ttf'; then return 'Array must be provided/ttf/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenArrayMustBeProvidedAndTtf_thenReturnArrayMustBeProvidedTtf() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("Array must be provided", "ttf", "/");

    // Assert
    assertEquals("Array must be provided/ttf/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code : Array was null} and {@code 42}.
   *   <li>Then return {@code : Array was null/42/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when ': Array was null' and '42'; then return ': Array was null/42/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenArrayWasNullAnd42_thenReturnArrayWasNull42() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath(": Array was null", "42", "/");

    // Assert
    assertEquals(": Array was null/42/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code : Array was null} and {@code : Array was null}.
   *   <li>Then return {@code : Array was null/: Array was null/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when ': Array was null' and ': Array was null'; then return ': Array was null/: Array was null/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenArrayWasNullAndArrayWasNull_thenReturnArrayWasNullArrayWasNull() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath(": Array was null", ": Array was null", "/");

    // Assert
    assertEquals(": Array was null/: Array was null/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code : Array was null} and {@code Segs}.
   *   <li>Then return {@code : Array was null/Segs/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when ': Array was null' and 'Segs'; then return ': Array was null/Segs/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenArrayWasNullAndSegs_thenReturnArrayWasNullSegs() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath(": Array was null", "Segs", "/");

    // Assert
    assertEquals(": Array was null/Segs/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code : Array was null} and {@code /+}.
   *   <li>Then return {@code : Array was null/+}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when ': Array was null' and '/+'; then return ': Array was null/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenArrayWasNullAndSlashPlusSign_thenReturnArrayWasNull() {
    // Arrange, Act and Assert
    assertEquals(": Array was null/+", WebUtilities.mkPath(": Array was null", "/+"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code : Array was null} and {@code /+}.
   *   <li>Then return {@code : Array was null/+/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when ': Array was null' and '/+'; then return ': Array was null/+/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenArrayWasNullAndSlashPlusSign_thenReturnArrayWasNull2() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath(": Array was null", "/+", "/");

    // Assert
    assertEquals(": Array was null/+/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code : Array was null} and {@code /}.
   *   <li>Then return {@code : Array was null/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when ': Array was null' and '/'; then return ': Array was null/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenArrayWasNullAndSlash_thenReturnArrayWasNull() {
    // Arrange, Act and Assert
    assertEquals(": Array was null/", WebUtilities.mkPath(": Array was null", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code : Array was null} and {@code /}.
   *   <li>Then return {@code : Array was null/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when ': Array was null' and '/'; then return ': Array was null/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenArrayWasNullAndSlash_thenReturnArrayWasNull2() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath(": Array was null", "/", "/");

    // Assert
    assertEquals(": Array was null/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code : Array was null} and {@code ttf}.
   *   <li>Then return {@code : Array was null/ttf/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when ': Array was null' and 'ttf'; then return ': Array was null/ttf/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenArrayWasNullAndTtf_thenReturnArrayWasNullTtf() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath(": Array was null", "ttf", "/");

    // Assert
    assertEquals(": Array was null/ttf/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code : Array was null} and {@code yyyy-MM-dd}.
   *   <li>Then return {@code : Array was null/yyyy-MM-dd/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when ': Array was null' and 'yyyy-MM-dd'; then return ': Array was null/yyyy-MM-dd/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenArrayWasNullAndYyyyMmDd_thenReturnArrayWasNullYyyyMmDd() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath(": Array was null", "yyyy-MM-dd", "/");

    // Assert
    assertEquals(": Array was null/yyyy-MM-dd/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code Predicate must be provided} and {@code 42}.
   *   <li>Then return {@code Predicate must be provided/42/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when 'Predicate must be provided' and '42'; then return 'Predicate must be provided/42/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenPredicateMustBeProvidedAnd42_thenReturnPredicateMustBeProvided42() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("Predicate must be provided", "42", "/");

    // Assert
    assertEquals("Predicate must be provided/42/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code Predicate must be provided} and {@code /}.
   *   <li>Then return {@code Predicate must be provided/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when 'Predicate must be provided' and '/'; then return 'Predicate must be provided/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenPredicateMustBeProvidedAndSlash_thenReturnPredicateMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals(
        "Predicate must be provided/", WebUtilities.mkPath("Predicate must be provided", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code Predicate must be provided} and {@code /}.
   *   <li>Then return {@code Predicate must be provided/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when 'Predicate must be provided' and '/'; then return 'Predicate must be provided/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenPredicateMustBeProvidedAndSlash_thenReturnPredicateMustBeProvided2() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("Predicate must be provided", "/", "/");

    // Assert
    assertEquals("Predicate must be provided/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code : Predicate was null} and {@code 42}.
   *   <li>Then return {@code : Predicate was null/42/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when ': Predicate was null' and '42'; then return ': Predicate was null/42/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenPredicateWasNullAnd42_thenReturnPredicateWasNull42() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath(": Predicate was null", "42", "/");

    // Assert
    assertEquals(": Predicate was null/42/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code : Predicate was null} and {@code Segs}.
   *   <li>Then return {@code : Predicate was null/Segs/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when ': Predicate was null' and 'Segs'; then return ': Predicate was null/Segs/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenPredicateWasNullAndSegs_thenReturnPredicateWasNullSegs() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath(": Predicate was null", "Segs", "/");

    // Assert
    assertEquals(": Predicate was null/Segs/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code : Predicate was null} and {@code /+}.
   *   <li>Then return {@code : Predicate was null/+}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when ': Predicate was null' and '/+'; then return ': Predicate was null/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenPredicateWasNullAndSlashPlusSign_thenReturnPredicateWasNull() {
    // Arrange, Act and Assert
    assertEquals(": Predicate was null/+", WebUtilities.mkPath(": Predicate was null", "/+"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code : Predicate was null} and {@code /+}.
   *   <li>Then return {@code : Predicate was null/+/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when ': Predicate was null' and '/+'; then return ': Predicate was null/+/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenPredicateWasNullAndSlashPlusSign_thenReturnPredicateWasNull2() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath(": Predicate was null", "/+", "/");

    // Assert
    assertEquals(": Predicate was null/+/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code : Predicate was null} and {@code /}.
   *   <li>Then return {@code : Predicate was null/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when ': Predicate was null' and '/'; then return ': Predicate was null/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenPredicateWasNullAndSlash_thenReturnPredicateWasNull() {
    // Arrange, Act and Assert
    assertEquals(": Predicate was null/", WebUtilities.mkPath(": Predicate was null", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code : Predicate was null} and {@code /}.
   *   <li>Then return {@code : Predicate was null/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when ': Predicate was null' and '/'; then return ': Predicate was null/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenPredicateWasNullAndSlash_thenReturnPredicateWasNull2() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath(": Predicate was null", "/", "/");

    // Assert
    assertEquals(": Predicate was null/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code : Predicate was null} and {@code ttf}.
   *   <li>Then return {@code : Predicate was null/ttf/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when ': Predicate was null' and 'ttf'; then return ': Predicate was null/ttf/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenPredicateWasNullAndTtf_thenReturnPredicateWasNullTtf() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath(": Predicate was null", "ttf", "/");

    // Assert
    assertEquals(": Predicate was null/ttf/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code : Predicate was null} and {@code yyyy-MM-dd}.
   *   <li>Then return {@code : Predicate was null/yyyy-MM-dd/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when ': Predicate was null' and 'yyyy-MM-dd'; then return ': Predicate was null/yyyy-MM-dd/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenPredicateWasNullAndYyyyMmDd_thenReturnPredicateWasNullYyyyMmDd() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath(": Predicate was null", "yyyy-MM-dd", "/");

    // Assert
    assertEquals(": Predicate was null/yyyy-MM-dd/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code Segs} and {@code 42}.
   *   <li>Then return {@code Segs/42/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'Segs' and '42'; then return 'Segs/42/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSegsAnd42_thenReturnSegs42() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("Segs", "42", "/");

    // Assert
    assertEquals("Segs/42/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code Segs} and {@code Array must be provided}.
   *   <li>Then return {@code Segs/Array must be provided/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when 'Segs' and 'Array must be provided'; then return 'Segs/Array must be provided/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSegsAndArrayMustBeProvided_thenReturnSegsArrayMustBeProvided() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("Segs", "Array must be provided", "/");

    // Assert
    assertEquals("Segs/Array must be provided/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code Segs} and {@code : Array was null}.
   *   <li>Then return {@code Segs/: Array was null/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when 'Segs' and ': Array was null'; then return 'Segs/: Array was null/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSegsAndArrayWasNull_thenReturnSegsArrayWasNull() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("Segs", ": Array was null", "/");

    // Assert
    assertEquals("Segs/: Array was null/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code Segs} and {@code : Predicate was null}.
   *   <li>Then return {@code Segs/: Predicate was null/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when 'Segs' and ': Predicate was null'; then return 'Segs/: Predicate was null/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSegsAndPredicateWasNull_thenReturnSegsPredicateWasNull() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("Segs", ": Predicate was null", "/");

    // Assert
    assertEquals("Segs/: Predicate was null/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code Segs} and {@code Segs}.
   *   <li>Then return {@code Segs/Segs/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'Segs' and 'Segs'; then return 'Segs/Segs/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSegsAndSegs_thenReturnSegsSegs() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("Segs", "Segs", "/");

    // Assert
    assertEquals("Segs/Segs/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code Segs} and {@code /+}.
   *   <li>Then return {@code Segs/+}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'Segs' and '/+'; then return 'Segs/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSegsAndSlashPlusSign_thenReturnSegs() {
    // Arrange, Act and Assert
    assertEquals("Segs/+", WebUtilities.mkPath("Segs", "/+"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code Segs} and {@code /+}.
   *   <li>Then return {@code Segs/+/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'Segs' and '/+'; then return 'Segs/+/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSegsAndSlashPlusSign_thenReturnSegs2() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("Segs", "/+", "/");

    // Assert
    assertEquals("Segs/+/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code Segs} and {@code /}.
   *   <li>Then return {@code Segs/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'Segs' and '/'; then return 'Segs/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSegsAndSlash_thenReturnSegs() {
    // Arrange, Act and Assert
    assertEquals("Segs/", WebUtilities.mkPath("Segs", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code Segs} and {@code /}.
   *   <li>Then return {@code Segs/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'Segs' and '/'; then return 'Segs/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSegsAndSlash_thenReturnSegs2() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("Segs", "/", "/");

    // Assert
    assertEquals("Segs/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code Segs} and {@code ttf}.
   *   <li>Then return {@code Segs/ttf/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'Segs' and 'ttf'; then return 'Segs/ttf/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSegsAndTtf_thenReturnSegsTtf() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("Segs", "ttf", "/");

    // Assert
    assertEquals("Segs/ttf/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code Segs} and {@code yyyy-MM-dd}.
   *   <li>Then return {@code Segs/yyyy-MM-dd/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when 'Segs' and 'yyyy-MM-dd'; then return 'Segs/yyyy-MM-dd/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSegsAndYyyyMmDd_thenReturnSegsYyyyMmDd() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("Segs", "yyyy-MM-dd", "/");

    // Assert
    assertEquals("Segs/yyyy-MM-dd/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code Segs}.
   *   <li>Then return {@code Segs}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'Segs'; then return 'Segs'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSegs_thenReturnSegs() {
    // Arrange, Act and Assert
    assertEquals("Segs", WebUtilities.mkPath("Segs"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code 42}.
   *   <li>Then return {@code /42}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '42'; then return '/42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAnd42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("/42", WebUtilities.mkPath("/", "42"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code 42}.
   *   <li>Then return {@code /42/Array must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '42'; then return '/42/Array must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAnd42_thenReturn42ArrayMustBeProvided() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "42", "Array must be provided");

    // Assert
    assertEquals("/42/Array must be provided", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code 42}.
   *   <li>Then return {@code /42/: Array was null}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '42'; then return '/42/: Array was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAnd42_thenReturn42ArrayWasNull() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "42", ": Array was null");

    // Assert
    assertEquals("/42/: Array was null", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code 42}.
   *   <li>Then return {@code /42/Cannot convert empty or null segments to path}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and '42'; then return '/42/Cannot convert empty or null segments to path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAnd42_thenReturn42CannotConvertEmptyOrNullSegmentsToPath() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath("/", "42", "Cannot convert empty or null segments to path");

    // Assert
    assertEquals("/42/Cannot convert empty or null segments to path", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code 42}.
   *   <li>Then return {@code /42/Predicate must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and '42'; then return '/42/Predicate must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAnd42_thenReturn42PredicateMustBeProvided() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "42", "Predicate must be provided");

    // Assert
    assertEquals("/42/Predicate must be provided", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code 42}.
   *   <li>Then return {@code /42/: Predicate was null}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '42'; then return '/42/: Predicate was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAnd42_thenReturn42PredicateWasNull() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "42", ": Predicate was null");

    // Assert
    assertEquals("/42/: Predicate was null", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code 42}.
   *   <li>Then return {@code /42/Segs}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '42'; then return '/42/Segs'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAnd42_thenReturn42Segs() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "42", "Segs");

    // Assert
    assertEquals("/42/Segs", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code 42}.
   *   <li>Then return {@code /42/ttf}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '42'; then return '/42/ttf'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAnd42_thenReturn42Ttf() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "42", "ttf");

    // Assert
    assertEquals("/42/ttf", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code 42}.
   *   <li>Then return {@code /42/yyyy-MM-dd}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '42'; then return '/42/yyyy-MM-dd'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAnd42_thenReturn42YyyyMmDd() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "42", "yyyy-MM-dd");

    // Assert
    assertEquals("/42/yyyy-MM-dd", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code 42}.
   *   <li>Then return {@code /42/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '42'; then return '/42/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAnd42_thenReturn422() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "42", "/");

    // Assert
    assertEquals("/42/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code 42}.
   *   <li>Then return {@code /42/+}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '42'; then return '/42/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAnd42_thenReturn423() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "42", "/+");

    // Assert
    assertEquals("/42/+", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code 42}.
   *   <li>Then return {@code /42/42}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '42'; then return '/42/42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAnd42_thenReturn4242() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "42", "42");

    // Assert
    assertEquals("/42/42", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code Array must be provided}.
   *   <li>Then return {@code /Array must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and 'Array must be provided'; then return '/Array must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayMustBeProvided_thenReturnArrayMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("/Array must be provided", WebUtilities.mkPath("/", "Array must be provided"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code Array must be provided}.
   *   <li>Then return {@code /Array must be provided/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and 'Array must be provided'; then return '/Array must be provided/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayMustBeProvided_thenReturnArrayMustBeProvided2() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "Array must be provided", "/");

    // Assert
    assertEquals("/Array must be provided/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code Array must be provided}.
   *   <li>Then return {@code /Array must be provided/+}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and 'Array must be provided'; then return '/Array must be provided/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayMustBeProvided_thenReturnArrayMustBeProvided3() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "Array must be provided", "/+");

    // Assert
    assertEquals("/Array must be provided/+", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code Array must be provided}.
   *   <li>Then return {@code /Array must be provided/42}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and 'Array must be provided'; then return '/Array must be provided/42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayMustBeProvided_thenReturnArrayMustBeProvided42() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "Array must be provided", "42");

    // Assert
    assertEquals("/Array must be provided/42", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code Array must be provided}.
   *   <li>Then return {@code /Array must be provided/Segs}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and 'Array must be provided'; then return '/Array must be provided/Segs'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayMustBeProvided_thenReturnArrayMustBeProvidedSegs() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "Array must be provided", "Segs");

    // Assert
    assertEquals("/Array must be provided/Segs", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code Array must be provided}.
   *   <li>Then return {@code /Array must be provided/ttf}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and 'Array must be provided'; then return '/Array must be provided/ttf'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayMustBeProvided_thenReturnArrayMustBeProvidedTtf() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "Array must be provided", "ttf");

    // Assert
    assertEquals("/Array must be provided/ttf", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code Array must be provided}.
   *   <li>Then return {@code /Array must be provided/yyyy-MM-dd}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and 'Array must be provided'; then return '/Array must be provided/yyyy-MM-dd'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayMustBeProvided_thenReturnArrayMustBeProvidedYyyyMmDd() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "Array must be provided", "yyyy-MM-dd");

    // Assert
    assertEquals("/Array must be provided/yyyy-MM-dd", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code : Array was null}.
   *   <li>Then return {@code /: Array was null}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and ': Array was null'; then return '/: Array was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayWasNull_thenReturnArrayWasNull() {
    // Arrange, Act and Assert
    assertEquals("/: Array was null", WebUtilities.mkPath("/", ": Array was null"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code : Array was null}.
   *   <li>Then return {@code /: Array was null/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and ': Array was null'; then return '/: Array was null/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayWasNull_thenReturnArrayWasNull2() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", ": Array was null", "/");

    // Assert
    assertEquals("/: Array was null/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code : Array was null}.
   *   <li>Then return {@code /: Array was null/+}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and ': Array was null'; then return '/: Array was null/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayWasNull_thenReturnArrayWasNull3() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", ": Array was null", "/+");

    // Assert
    assertEquals("/: Array was null/+", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code : Array was null}.
   *   <li>Then return {@code /: Array was null/42}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and ': Array was null'; then return '/: Array was null/42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayWasNull_thenReturnArrayWasNull42() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", ": Array was null", "42");

    // Assert
    assertEquals("/: Array was null/42", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code : Array was null}.
   *   <li>Then return {@code /: Array was null/Array must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and ': Array was null'; then return '/: Array was null/Array must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayWasNull_thenReturnArrayWasNullArrayMustBeProvided() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath("/", ": Array was null", "Array must be provided");

    // Assert
    assertEquals("/: Array was null/Array must be provided", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code : Array was null}.
   *   <li>Then return {@code /: Array was null/: Array was null}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and ': Array was null'; then return '/: Array was null/: Array was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayWasNull_thenReturnArrayWasNullArrayWasNull() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", ": Array was null", ": Array was null");

    // Assert
    assertEquals("/: Array was null/: Array was null", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code : Array was null}.
   *   <li>Then return {@code /: Array was null/: Predicate was null}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and ': Array was null'; then return '/: Array was null/: Predicate was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayWasNull_thenReturnArrayWasNullPredicateWasNull() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath("/", ": Array was null", ": Predicate was null");

    // Assert
    assertEquals("/: Array was null/: Predicate was null", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code : Array was null}.
   *   <li>Then return {@code /: Array was null/Segs}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and ': Array was null'; then return '/: Array was null/Segs'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayWasNull_thenReturnArrayWasNullSegs() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", ": Array was null", "Segs");

    // Assert
    assertEquals("/: Array was null/Segs", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code : Array was null}.
   *   <li>Then return {@code /: Array was null/ttf}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and ': Array was null'; then return '/: Array was null/ttf'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayWasNull_thenReturnArrayWasNullTtf() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", ": Array was null", "ttf");

    // Assert
    assertEquals("/: Array was null/ttf", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code : Array was null}.
   *   <li>Then return {@code /: Array was null/yyyy-MM-dd}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and ': Array was null'; then return '/: Array was null/yyyy-MM-dd'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayWasNull_thenReturnArrayWasNullYyyyMmDd() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", ": Array was null", "yyyy-MM-dd");

    // Assert
    assertEquals("/: Array was null/yyyy-MM-dd", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code Predicate must be provided}.
   *   <li>Then return {@code /Predicate must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and 'Predicate must be provided'; then return '/Predicate must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndPredicateMustBeProvided_thenReturnPredicateMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals(
        "/Predicate must be provided", WebUtilities.mkPath("/", "Predicate must be provided"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code Predicate must be provided}.
   *   <li>Then return {@code /Predicate must be provided/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and 'Predicate must be provided'; then return '/Predicate must be provided/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndPredicateMustBeProvided_thenReturnPredicateMustBeProvided2() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "Predicate must be provided", "/");

    // Assert
    assertEquals("/Predicate must be provided/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code Predicate must be provided}.
   *   <li>Then return {@code /Predicate must be provided/+}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and 'Predicate must be provided'; then return '/Predicate must be provided/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndPredicateMustBeProvided_thenReturnPredicateMustBeProvided3() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "Predicate must be provided", "/+");

    // Assert
    assertEquals("/Predicate must be provided/+", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code : Predicate was null}.
   *   <li>Then return {@code /: Predicate was null}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and ': Predicate was null'; then return '/: Predicate was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndPredicateWasNull_thenReturnPredicateWasNull() {
    // Arrange, Act and Assert
    assertEquals("/: Predicate was null", WebUtilities.mkPath("/", ": Predicate was null"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code : Predicate was null}.
   *   <li>Then return {@code /: Predicate was null/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and ': Predicate was null'; then return '/: Predicate was null/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndPredicateWasNull_thenReturnPredicateWasNull2() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", ": Predicate was null", "/");

    // Assert
    assertEquals("/: Predicate was null/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code : Predicate was null}.
   *   <li>Then return {@code /: Predicate was null/+}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and ': Predicate was null'; then return '/: Predicate was null/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndPredicateWasNull_thenReturnPredicateWasNull3() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", ": Predicate was null", "/+");

    // Assert
    assertEquals("/: Predicate was null/+", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code : Predicate was null}.
   *   <li>Then return {@code /: Predicate was null/42}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and ': Predicate was null'; then return '/: Predicate was null/42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndPredicateWasNull_thenReturnPredicateWasNull42() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", ": Predicate was null", "42");

    // Assert
    assertEquals("/: Predicate was null/42", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code : Predicate was null}.
   *   <li>Then return {@code /: Predicate was null/: Array was null}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and ': Predicate was null'; then return '/: Predicate was null/: Array was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndPredicateWasNull_thenReturnPredicateWasNullArrayWasNull() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath("/", ": Predicate was null", ": Array was null");

    // Assert
    assertEquals("/: Predicate was null/: Array was null", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code : Predicate was null}.
   *   <li>Then return {@code /: Predicate was null/Segs}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and ': Predicate was null'; then return '/: Predicate was null/Segs'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndPredicateWasNull_thenReturnPredicateWasNullSegs() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", ": Predicate was null", "Segs");

    // Assert
    assertEquals("/: Predicate was null/Segs", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code : Predicate was null}.
   *   <li>Then return {@code /: Predicate was null/ttf}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and ': Predicate was null'; then return '/: Predicate was null/ttf'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndPredicateWasNull_thenReturnPredicateWasNullTtf() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", ": Predicate was null", "ttf");

    // Assert
    assertEquals("/: Predicate was null/ttf", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code : Predicate was null}.
   *   <li>Then return {@code /: Predicate was null/yyyy-MM-dd}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and ': Predicate was null'; then return '/: Predicate was null/yyyy-MM-dd'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndPredicateWasNull_thenReturnPredicateWasNullYyyyMmDd() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", ": Predicate was null", "yyyy-MM-dd");

    // Assert
    assertEquals("/: Predicate was null/yyyy-MM-dd", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code Segs}.
   *   <li>Then return {@code /Segs}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'Segs'; then return '/Segs'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSegs_thenReturnSegs() {
    // Arrange, Act and Assert
    assertEquals("/Segs", WebUtilities.mkPath("/", "Segs"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code Segs}.
   *   <li>Then return {@code /Segs/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'Segs'; then return '/Segs/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSegs_thenReturnSegs2() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "Segs", "/");

    // Assert
    assertEquals("/Segs/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code Segs}.
   *   <li>Then return {@code /Segs/+}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'Segs'; then return '/Segs/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSegs_thenReturnSegs3() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "Segs", "/+");

    // Assert
    assertEquals("/Segs/+", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code Segs}.
   *   <li>Then return {@code /Segs/42}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'Segs'; then return '/Segs/42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSegs_thenReturnSegs42() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "Segs", "42");

    // Assert
    assertEquals("/Segs/42", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code Segs}.
   *   <li>Then return {@code /Segs/Array must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and 'Segs'; then return '/Segs/Array must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSegs_thenReturnSegsArrayMustBeProvided() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "Segs", "Array must be provided");

    // Assert
    assertEquals("/Segs/Array must be provided", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code Segs}.
   *   <li>Then return {@code /Segs/: Array was null}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'Segs'; then return '/Segs/: Array was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSegs_thenReturnSegsArrayWasNull() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "Segs", ": Array was null");

    // Assert
    assertEquals("/Segs/: Array was null", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code Segs}.
   *   <li>Then return {@code /Segs/Cannot convert empty or null segments to path}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and 'Segs'; then return '/Segs/Cannot convert empty or null segments to path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSegs_thenReturnSegsCannotConvertEmptyOrNullSegmentsToPath() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath("/", "Segs", "Cannot convert empty or null segments to path");

    // Assert
    assertEquals("/Segs/Cannot convert empty or null segments to path", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code Segs}.
   *   <li>Then return {@code /Segs/Predicate must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and 'Segs'; then return '/Segs/Predicate must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSegs_thenReturnSegsPredicateMustBeProvided() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "Segs", "Predicate must be provided");

    // Assert
    assertEquals("/Segs/Predicate must be provided", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code Segs}.
   *   <li>Then return {@code /Segs/: Predicate was null}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and 'Segs'; then return '/Segs/: Predicate was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSegs_thenReturnSegsPredicateWasNull() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "Segs", ": Predicate was null");

    // Assert
    assertEquals("/Segs/: Predicate was null", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code Segs}.
   *   <li>Then return {@code /Segs/Segs}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'Segs'; then return '/Segs/Segs'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSegs_thenReturnSegsSegs() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "Segs", "Segs");

    // Assert
    assertEquals("/Segs/Segs", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code Segs}.
   *   <li>Then return {@code /Segs/ttf}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'Segs'; then return '/Segs/ttf'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSegs_thenReturnSegsTtf() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "Segs", "ttf");

    // Assert
    assertEquals("/Segs/ttf", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code Segs}.
   *   <li>Then return {@code /Segs/yyyy-MM-dd}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'Segs'; then return '/Segs/yyyy-MM-dd'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSegs_thenReturnSegsYyyyMmDd() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "Segs", "yyyy-MM-dd");

    // Assert
    assertEquals("/Segs/yyyy-MM-dd", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code /+}.
   *   <li>Then return {@code /+/42}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/+'; then return '/+/42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlashPlusSign_thenReturn42() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "/+", "42");

    // Assert
    assertEquals("/+/42", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code /+}.
   *   <li>Then return {@code /+/Array must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/+'; then return '/+/Array must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlashPlusSign_thenReturnArrayMustBeProvided() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "/+", "Array must be provided");

    // Assert
    assertEquals("/+/Array must be provided", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code /+}.
   *   <li>Then return {@code /+/: Array was null}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/+'; then return '/+/: Array was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlashPlusSign_thenReturnArrayWasNull() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "/+", ": Array was null");

    // Assert
    assertEquals("/+/: Array was null", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code /+}.
   *   <li>Then return {@code /+/Predicate must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and '/+'; then return '/+/Predicate must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlashPlusSign_thenReturnPredicateMustBeProvided() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "/+", "Predicate must be provided");

    // Assert
    assertEquals("/+/Predicate must be provided", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code /+}.
   *   <li>Then return {@code /+/: Predicate was null}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/+'; then return '/+/: Predicate was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlashPlusSign_thenReturnPredicateWasNull() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "/+", ": Predicate was null");

    // Assert
    assertEquals("/+/: Predicate was null", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code /+}.
   *   <li>Then return {@code /+/Segs}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/+'; then return '/+/Segs'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlashPlusSign_thenReturnSegs() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "/+", "Segs");

    // Assert
    assertEquals("/+/Segs", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code /+}.
   *   <li>Then return {@code /+}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/+'; then return '/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlashPlusSign_thenReturnSlashPlusSign() {
    // Arrange, Act and Assert
    assertEquals("/+", WebUtilities.mkPath("/", "/+"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code /+}.
   *   <li>Then return {@code /+/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/+'; then return '/+/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlashPlusSign_thenReturnSlashPlusSignSlash() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "/+", "/");

    // Assert
    assertEquals("/+/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code /+}.
   *   <li>Then return {@code /+/+}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/+'; then return '/+/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlashPlusSign_thenReturnSlashPlusSignSlashPlusSign() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "/+", "/+");

    // Assert
    assertEquals("/+/+", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code /+}.
   *   <li>Then return {@code /+/ttf}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/+'; then return '/+/ttf'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlashPlusSign_thenReturnTtf() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "/+", "ttf");

    // Assert
    assertEquals("/+/ttf", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code /+}.
   *   <li>Then return {@code /+/yyyy-MM-dd}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/+'; then return '/+/yyyy-MM-dd'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlashPlusSign_thenReturnYyyyMmDd() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "/+", "yyyy-MM-dd");

    // Assert
    assertEquals("/+/yyyy-MM-dd", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code /}.
   *   <li>Then return {@code /42}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/'; then return '/42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlash_thenReturn42() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "/", "42");

    // Assert
    assertEquals("/42", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code /}.
   *   <li>Then return {@code /Array must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/'; then return '/Array must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlash_thenReturnArrayMustBeProvided() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "/", "Array must be provided");

    // Assert
    assertEquals("/Array must be provided", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code /}.
   *   <li>Then return {@code /: Array was null}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/'; then return '/: Array was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlash_thenReturnArrayWasNull() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "/", ": Array was null");

    // Assert
    assertEquals("/: Array was null", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code /}.
   *   <li>Then return {@code /Cannot convert empty or null segments to path}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and '/'; then return '/Cannot convert empty or null segments to path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlash_thenReturnCannotConvertEmptyOrNullSegmentsToPath() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath("/", "/", "Cannot convert empty or null segments to path");

    // Assert
    assertEquals("/Cannot convert empty or null segments to path", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code /}.
   *   <li>Then return {@code /Predicate must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/'; then return '/Predicate must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlash_thenReturnPredicateMustBeProvided() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "/", "Predicate must be provided");

    // Assert
    assertEquals("/Predicate must be provided", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code /}.
   *   <li>Then return {@code /: Predicate was null}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/'; then return '/: Predicate was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlash_thenReturnPredicateWasNull() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "/", ": Predicate was null");

    // Assert
    assertEquals("/: Predicate was null", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code /}.
   *   <li>Then return {@code /Segs}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/'; then return '/Segs'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlash_thenReturnSegs() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "/", "Segs");

    // Assert
    assertEquals("/Segs", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code /}.
   *   <li>Then return {@code /}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/'; then return '/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlash_thenReturnSlash() {
    // Arrange, Act and Assert
    assertEquals("/", WebUtilities.mkPath("/", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code /}.
   *   <li>Then return {@code /}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/'; then return '/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlash_thenReturnSlash2() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "/", "/");

    // Assert
    assertEquals("/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code /}.
   *   <li>Then return {@code /+}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/'; then return '/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlash_thenReturnSlashPlusSign() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "/", "/+");

    // Assert
    assertEquals("/+", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code /}.
   *   <li>Then return {@code /ttf}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/'; then return '/ttf'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlash_thenReturnTtf() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "/", "ttf");

    // Assert
    assertEquals("/ttf", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code /}.
   *   <li>Then return {@code /yyyy-MM-dd}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/'; then return '/yyyy-MM-dd'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlash_thenReturnYyyyMmDd() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "/", "yyyy-MM-dd");

    // Assert
    assertEquals("/yyyy-MM-dd", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code ttf}.
   *   <li>Then return {@code /ttf}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'ttf'; then return '/ttf'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndTtf_thenReturnTtf() {
    // Arrange, Act and Assert
    assertEquals("/ttf", WebUtilities.mkPath("/", "ttf"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code ttf}.
   *   <li>Then return {@code /ttf/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'ttf'; then return '/ttf/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndTtf_thenReturnTtf2() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "ttf", "/");

    // Assert
    assertEquals("/ttf/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code ttf}.
   *   <li>Then return {@code /ttf/+}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'ttf'; then return '/ttf/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndTtf_thenReturnTtf3() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "ttf", "/+");

    // Assert
    assertEquals("/ttf/+", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code ttf}.
   *   <li>Then return {@code /ttf/42}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'ttf'; then return '/ttf/42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndTtf_thenReturnTtf42() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "ttf", "42");

    // Assert
    assertEquals("/ttf/42", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code ttf}.
   *   <li>Then return {@code /ttf/Array must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and 'ttf'; then return '/ttf/Array must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndTtf_thenReturnTtfArrayMustBeProvided() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "ttf", "Array must be provided");

    // Assert
    assertEquals("/ttf/Array must be provided", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code ttf}.
   *   <li>Then return {@code /ttf/: Array was null}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'ttf'; then return '/ttf/: Array was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndTtf_thenReturnTtfArrayWasNull() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "ttf", ": Array was null");

    // Assert
    assertEquals("/ttf/: Array was null", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code ttf}.
   *   <li>Then return {@code /ttf/Cannot convert empty or null segments to path}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and 'ttf'; then return '/ttf/Cannot convert empty or null segments to path'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndTtf_thenReturnTtfCannotConvertEmptyOrNullSegmentsToPath() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath("/", "ttf", "Cannot convert empty or null segments to path");

    // Assert
    assertEquals("/ttf/Cannot convert empty or null segments to path", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code ttf}.
   *   <li>Then return {@code /ttf/Predicate must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and 'ttf'; then return '/ttf/Predicate must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndTtf_thenReturnTtfPredicateMustBeProvided() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "ttf", "Predicate must be provided");

    // Assert
    assertEquals("/ttf/Predicate must be provided", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code ttf}.
   *   <li>Then return {@code /ttf/: Predicate was null}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'ttf'; then return '/ttf/: Predicate was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndTtf_thenReturnTtfPredicateWasNull() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "ttf", ": Predicate was null");

    // Assert
    assertEquals("/ttf/: Predicate was null", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code ttf}.
   *   <li>Then return {@code /ttf/Segs}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'ttf'; then return '/ttf/Segs'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndTtf_thenReturnTtfSegs() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "ttf", "Segs");

    // Assert
    assertEquals("/ttf/Segs", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code ttf}.
   *   <li>Then return {@code /ttf/ttf}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'ttf'; then return '/ttf/ttf'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndTtf_thenReturnTtfTtf() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "ttf", "ttf");

    // Assert
    assertEquals("/ttf/ttf", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code ttf}.
   *   <li>Then return {@code /ttf/yyyy-MM-dd}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'ttf'; then return '/ttf/yyyy-MM-dd'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndTtf_thenReturnTtfYyyyMmDd() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "ttf", "yyyy-MM-dd");

    // Assert
    assertEquals("/ttf/yyyy-MM-dd", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code yyyy-MM-dd}.
   *   <li>Then return {@code /yyyy-MM-dd}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'yyyy-MM-dd'; then return '/yyyy-MM-dd'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndYyyyMmDd_thenReturnYyyyMmDd() {
    // Arrange, Act and Assert
    assertEquals("/yyyy-MM-dd", WebUtilities.mkPath("/", "yyyy-MM-dd"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code yyyy-MM-dd}.
   *   <li>Then return {@code /yyyy-MM-dd/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'yyyy-MM-dd'; then return '/yyyy-MM-dd/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndYyyyMmDd_thenReturnYyyyMmDd2() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "yyyy-MM-dd", "/");

    // Assert
    assertEquals("/yyyy-MM-dd/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code yyyy-MM-dd}.
   *   <li>Then return {@code /yyyy-MM-dd/+}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'yyyy-MM-dd'; then return '/yyyy-MM-dd/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndYyyyMmDd_thenReturnYyyyMmDd3() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "yyyy-MM-dd", "/+");

    // Assert
    assertEquals("/yyyy-MM-dd/+", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code yyyy-MM-dd}.
   *   <li>Then return {@code /yyyy-MM-dd/42}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'yyyy-MM-dd'; then return '/yyyy-MM-dd/42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndYyyyMmDd_thenReturnYyyyMmDd42() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "yyyy-MM-dd", "42");

    // Assert
    assertEquals("/yyyy-MM-dd/42", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code yyyy-MM-dd}.
   *   <li>Then return {@code /yyyy-MM-dd/Array must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and 'yyyy-MM-dd'; then return '/yyyy-MM-dd/Array must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndYyyyMmDd_thenReturnYyyyMmDdArrayMustBeProvided() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "yyyy-MM-dd", "Array must be provided");

    // Assert
    assertEquals("/yyyy-MM-dd/Array must be provided", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code yyyy-MM-dd}.
   *   <li>Then return {@code /yyyy-MM-dd/: Array was null}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and 'yyyy-MM-dd'; then return '/yyyy-MM-dd/: Array was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndYyyyMmDd_thenReturnYyyyMmDdArrayWasNull() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "yyyy-MM-dd", ": Array was null");

    // Assert
    assertEquals("/yyyy-MM-dd/: Array was null", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code yyyy-MM-dd}.
   *   <li>Then return {@code /yyyy-MM-dd/Predicate must be provided}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and 'yyyy-MM-dd'; then return '/yyyy-MM-dd/Predicate must be provided'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndYyyyMmDd_thenReturnYyyyMmDdPredicateMustBeProvided() {
    // Arrange and Act
    String actualMkPathResult =
        WebUtilities.mkPath("/", "yyyy-MM-dd", "Predicate must be provided");

    // Assert
    assertEquals("/yyyy-MM-dd/Predicate must be provided", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code yyyy-MM-dd}.
   *   <li>Then return {@code /yyyy-MM-dd/: Predicate was null}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and 'yyyy-MM-dd'; then return '/yyyy-MM-dd/: Predicate was null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndYyyyMmDd_thenReturnYyyyMmDdPredicateWasNull() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "yyyy-MM-dd", ": Predicate was null");

    // Assert
    assertEquals("/yyyy-MM-dd/: Predicate was null", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code yyyy-MM-dd}.
   *   <li>Then return {@code /yyyy-MM-dd/Segs}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'yyyy-MM-dd'; then return '/yyyy-MM-dd/Segs'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndYyyyMmDd_thenReturnYyyyMmDdSegs() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "yyyy-MM-dd", "Segs");

    // Assert
    assertEquals("/yyyy-MM-dd/Segs", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code yyyy-MM-dd}.
   *   <li>Then return {@code /yyyy-MM-dd/ttf}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'yyyy-MM-dd'; then return '/yyyy-MM-dd/ttf'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndYyyyMmDd_thenReturnYyyyMmDdTtf() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "yyyy-MM-dd", "ttf");

    // Assert
    assertEquals("/yyyy-MM-dd/ttf", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /} and {@code yyyy-MM-dd}.
   *   <li>Then return {@code /yyyy-MM-dd/yyyy-MM-dd}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/' and 'yyyy-MM-dd'; then return '/yyyy-MM-dd/yyyy-MM-dd'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndYyyyMmDd_thenReturnYyyyMmDdYyyyMmDd() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/", "yyyy-MM-dd", "yyyy-MM-dd");

    // Assert
    assertEquals("/yyyy-MM-dd/yyyy-MM-dd", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /+} and {@code 42}.
   *   <li>Then return {@code /+/42/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/+' and '42'; then return '/+/42/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashPlusSignAnd42_thenReturn42() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/+", "42", "/");

    // Assert
    assertEquals("/+/42/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /+} and {@code Array must be provided}.
   *   <li>Then return {@code /+/Array must be provided/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/+' and 'Array must be provided'; then return '/+/Array must be provided/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashPlusSignAndArrayMustBeProvided_thenReturnArrayMustBeProvided() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/+", "Array must be provided", "/");

    // Assert
    assertEquals("/+/Array must be provided/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /+} and {@code : Array was null}.
   *   <li>Then return {@code /+/: Array was null/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/+' and ': Array was null'; then return '/+/: Array was null/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashPlusSignAndArrayWasNull_thenReturnArrayWasNull() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/+", ": Array was null", "/");

    // Assert
    assertEquals("/+/: Array was null/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /+} and {@code : Predicate was null}.
   *   <li>Then return {@code /+/: Predicate was null/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when '/+' and ': Predicate was null'; then return '/+/: Predicate was null/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashPlusSignAndPredicateWasNull_thenReturnPredicateWasNull() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/+", ": Predicate was null", "/");

    // Assert
    assertEquals("/+/: Predicate was null/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /+} and {@code Segs}.
   *   <li>Then return {@code /+/Segs/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/+' and 'Segs'; then return '/+/Segs/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashPlusSignAndSegs_thenReturnSegs() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/+", "Segs", "/");

    // Assert
    assertEquals("/+/Segs/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /+} and {@code /}.
   *   <li>Then return {@code /+/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/+' and '/'; then return '/+/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashPlusSignAndSlash_thenReturnSlashPlusSignSlash() {
    // Arrange, Act and Assert
    assertEquals("/+/", WebUtilities.mkPath("/+", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /+} and {@code /}.
   *   <li>Then return {@code /+/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/+' and '/'; then return '/+/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashPlusSignAndSlash_thenReturnSlashPlusSignSlash2() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/+", "/", "/");

    // Assert
    assertEquals("/+/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /+} and {@code ttf}.
   *   <li>Then return {@code /+/ttf/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/+' and 'ttf'; then return '/+/ttf/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashPlusSignAndTtf_thenReturnTtf() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/+", "ttf", "/");

    // Assert
    assertEquals("/+/ttf/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code /+} and {@code yyyy-MM-dd}.
   *   <li>Then return {@code /+/yyyy-MM-dd/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/+' and 'yyyy-MM-dd'; then return '/+/yyyy-MM-dd/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashPlusSignAndYyyyMmDd_thenReturnYyyyMmDd() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("/+", "yyyy-MM-dd", "/");

    // Assert
    assertEquals("/+/yyyy-MM-dd/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code ttf} and {@code 42}.
   *   <li>Then return {@code ttf/42/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'ttf' and '42'; then return 'ttf/42/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenTtfAnd42_thenReturnTtf42() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("ttf", "42", "/");

    // Assert
    assertEquals("ttf/42/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code ttf} and {@code Array must be provided}.
   *   <li>Then return {@code ttf/Array must be provided/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when 'ttf' and 'Array must be provided'; then return 'ttf/Array must be provided/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenTtfAndArrayMustBeProvided_thenReturnTtfArrayMustBeProvided() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("ttf", "Array must be provided", "/");

    // Assert
    assertEquals("ttf/Array must be provided/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code ttf} and {@code : Array was null}.
   *   <li>Then return {@code ttf/: Array was null/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when 'ttf' and ': Array was null'; then return 'ttf/: Array was null/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenTtfAndArrayWasNull_thenReturnTtfArrayWasNull() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("ttf", ": Array was null", "/");

    // Assert
    assertEquals("ttf/: Array was null/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code ttf} and {@code : Predicate was null}.
   *   <li>Then return {@code ttf/: Predicate was null/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when 'ttf' and ': Predicate was null'; then return 'ttf/: Predicate was null/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenTtfAndPredicateWasNull_thenReturnTtfPredicateWasNull() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("ttf", ": Predicate was null", "/");

    // Assert
    assertEquals("ttf/: Predicate was null/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code ttf} and {@code Segs}.
   *   <li>Then return {@code ttf/Segs/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'ttf' and 'Segs'; then return 'ttf/Segs/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenTtfAndSegs_thenReturnTtfSegs() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("ttf", "Segs", "/");

    // Assert
    assertEquals("ttf/Segs/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code ttf} and {@code /+}.
   *   <li>Then return {@code ttf/+}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'ttf' and '/+'; then return 'ttf/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenTtfAndSlashPlusSign_thenReturnTtf() {
    // Arrange, Act and Assert
    assertEquals("ttf/+", WebUtilities.mkPath("ttf", "/+"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code ttf} and {@code /+}.
   *   <li>Then return {@code ttf/+/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'ttf' and '/+'; then return 'ttf/+/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenTtfAndSlashPlusSign_thenReturnTtf2() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("ttf", "/+", "/");

    // Assert
    assertEquals("ttf/+/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code ttf} and {@code /}.
   *   <li>Then return {@code ttf/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'ttf' and '/'; then return 'ttf/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenTtfAndSlash_thenReturnTtf() {
    // Arrange, Act and Assert
    assertEquals("ttf/", WebUtilities.mkPath("ttf", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code ttf} and {@code /}.
   *   <li>Then return {@code ttf/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'ttf' and '/'; then return 'ttf/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenTtfAndSlash_thenReturnTtf2() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("ttf", "/", "/");

    // Assert
    assertEquals("ttf/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code ttf} and {@code ttf}.
   *   <li>Then return {@code ttf/ttf/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'ttf' and 'ttf'; then return 'ttf/ttf/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenTtfAndTtf_thenReturnTtfTtf() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("ttf", "ttf", "/");

    // Assert
    assertEquals("ttf/ttf/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code ttf} and {@code yyyy-MM-dd}.
   *   <li>Then return {@code ttf/yyyy-MM-dd/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'ttf' and 'yyyy-MM-dd'; then return 'ttf/yyyy-MM-dd/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenTtfAndYyyyMmDd_thenReturnTtfYyyyMmDd() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("ttf", "yyyy-MM-dd", "/");

    // Assert
    assertEquals("ttf/yyyy-MM-dd/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code yyyy-MM-dd} and {@code 42}.
   *   <li>Then return {@code yyyy-MM-dd/42/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'yyyy-MM-dd' and '42'; then return 'yyyy-MM-dd/42/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenYyyyMmDdAnd42_thenReturnYyyyMmDd42() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("yyyy-MM-dd", "42", "/");

    // Assert
    assertEquals("yyyy-MM-dd/42/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code yyyy-MM-dd} and {@code : Array was null}.
   *   <li>Then return {@code yyyy-MM-dd/: Array was null/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when 'yyyy-MM-dd' and ': Array was null'; then return 'yyyy-MM-dd/: Array was null/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenYyyyMmDdAndArrayWasNull_thenReturnYyyyMmDdArrayWasNull() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("yyyy-MM-dd", ": Array was null", "/");

    // Assert
    assertEquals("yyyy-MM-dd/: Array was null/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code yyyy-MM-dd} and {@code : Predicate was null}.
   *   <li>Then return {@code yyyy-MM-dd/: Predicate was null/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when 'yyyy-MM-dd' and ': Predicate was null'; then return 'yyyy-MM-dd/: Predicate was null/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenYyyyMmDdAndPredicateWasNull_thenReturnYyyyMmDdPredicateWasNull() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("yyyy-MM-dd", ": Predicate was null", "/");

    // Assert
    assertEquals("yyyy-MM-dd/: Predicate was null/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code yyyy-MM-dd} and {@code Segs}.
   *   <li>Then return {@code yyyy-MM-dd/Segs/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when 'yyyy-MM-dd' and 'Segs'; then return 'yyyy-MM-dd/Segs/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenYyyyMmDdAndSegs_thenReturnYyyyMmDdSegs() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("yyyy-MM-dd", "Segs", "/");

    // Assert
    assertEquals("yyyy-MM-dd/Segs/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code yyyy-MM-dd} and {@code /+}.
   *   <li>Then return {@code yyyy-MM-dd/+}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'yyyy-MM-dd' and '/+'; then return 'yyyy-MM-dd/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenYyyyMmDdAndSlashPlusSign_thenReturnYyyyMmDd() {
    // Arrange, Act and Assert
    assertEquals("yyyy-MM-dd/+", WebUtilities.mkPath("yyyy-MM-dd", "/+"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code yyyy-MM-dd} and {@code /+}.
   *   <li>Then return {@code yyyy-MM-dd/+/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'yyyy-MM-dd' and '/+'; then return 'yyyy-MM-dd/+/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenYyyyMmDdAndSlashPlusSign_thenReturnYyyyMmDd2() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("yyyy-MM-dd", "/+", "/");

    // Assert
    assertEquals("yyyy-MM-dd/+/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code yyyy-MM-dd} and {@code /}.
   *   <li>Then return {@code yyyy-MM-dd/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'yyyy-MM-dd' and '/'; then return 'yyyy-MM-dd/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenYyyyMmDdAndSlash_thenReturnYyyyMmDd() {
    // Arrange, Act and Assert
    assertEquals("yyyy-MM-dd/", WebUtilities.mkPath("yyyy-MM-dd", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code yyyy-MM-dd} and {@code /}.
   *   <li>Then return {@code yyyy-MM-dd/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'yyyy-MM-dd' and '/'; then return 'yyyy-MM-dd/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenYyyyMmDdAndSlash_thenReturnYyyyMmDd2() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("yyyy-MM-dd", "/", "/");

    // Assert
    assertEquals("yyyy-MM-dd/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code yyyy-MM-dd} and {@code ttf}.
   *   <li>Then return {@code yyyy-MM-dd/ttf/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'yyyy-MM-dd' and 'ttf'; then return 'yyyy-MM-dd/ttf/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenYyyyMmDdAndTtf_thenReturnYyyyMmDdTtf() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("yyyy-MM-dd", "ttf", "/");

    // Assert
    assertEquals("yyyy-MM-dd/ttf/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   *
   * <ul>
   *   <li>When {@code yyyy-MM-dd} and {@code yyyy-MM-dd}.
   *   <li>Then return {@code yyyy-MM-dd/yyyy-MM-dd/}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName(
      "Test mkPath(String[]); when 'yyyy-MM-dd' and 'yyyy-MM-dd'; then return 'yyyy-MM-dd/yyyy-MM-dd/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenYyyyMmDdAndYyyyMmDd_thenReturnYyyyMmDdYyyyMmDd() {
    // Arrange and Act
    String actualMkPathResult = WebUtilities.mkPath("yyyy-MM-dd", "yyyy-MM-dd", "/");

    // Assert
    assertEquals("yyyy-MM-dd/yyyy-MM-dd/", actualMkPathResult);
  }

  /**
   * Test {@link WebUtilities#attemptRender(Response, Object, Logger)}.
   *
   * <p>Method under test: {@link WebUtilities#attemptRender(Response, Object, Logger)}
   */
  @Test
  @DisplayName("Test attemptRender(Response, Object, Logger)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebUtilities.attemptRender(Response, Object, Logger)"})
  void testAttemptRender() {
    // Arrange
    Response res = mock(Response.class);
    doThrow(new IllegalArgumentException()).when(res).body(Mockito.<String>any());
    SubstituteLogger logger = new SubstituteLogger("Name", new LinkedList<>(), true);

    // Act
    WebUtilities.attemptRender(res, "Obj", logger);

    // Assert
    verify(res).body("\"Obj\"");
  }

  /**
   * Test {@link WebUtilities#attemptRender(Response, Object, Logger)}.
   *
   * <p>Method under test: {@link WebUtilities#attemptRender(Response, Object, Logger)}
   */
  @Test
  @DisplayName("Test attemptRender(Response, Object, Logger)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebUtilities.attemptRender(Response, Object, Logger)"})
  void testAttemptRender2() {
    // Arrange
    Response res = mock(Response.class);
    doThrow(new IllegalArgumentException()).when(res).body(Mockito.<String>any());
    SubstituteLogger logger = new SubstituteLogger("Name", new LinkedList<>(), false);

    // Act
    WebUtilities.attemptRender(res, "Obj", logger);

    // Assert
    verify(res).body("\"Obj\"");
  }

  /**
   * Test {@link WebUtilities#attemptRender(Response, Object, Logger)}.
   *
   * <p>Method under test: {@link WebUtilities#attemptRender(Response, Object, Logger)}
   */
  @Test
  @DisplayName("Test attemptRender(Response, Object, Logger)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebUtilities.attemptRender(Response, Object, Logger)"})
  void testAttemptRender3() {
    // Arrange
    Response res = mock(Response.class);
    doThrow(new IllegalArgumentException()).when(res).body(Mockito.<String>any());
    SubstituteLogger logger =
        new SubstituteLogger("res must not be null", new LinkedList<>(), true);
    EventRecordingLogger logger2 = new EventRecordingLogger(logger, new LinkedList<>());

    // Act
    WebUtilities.attemptRender(res, "Obj", logger2);

    // Assert
    verify(res).body("\"Obj\"");
  }

  /**
   * Test {@link WebUtilities#attemptRender(Response, Object, Logger)}.
   *
   * <p>Method under test: {@link WebUtilities#attemptRender(Response, Object, Logger)}
   */
  @Test
  @DisplayName("Test attemptRender(Response, Object, Logger)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebUtilities.attemptRender(Response, Object, Logger)"})
  void testAttemptRender4() {
    // Arrange
    Response res = mock(Response.class);
    doThrow(new IllegalArgumentException()).when(res).body(Mockito.<String>any());

    SubstituteLogger logger = new SubstituteLogger("Name", new LinkedList<>(), true);
    SubstituteLogger delegate =
        new SubstituteLogger("res must not be null", new LinkedList<>(), true);
    logger.setDelegate(delegate);

    // Act
    WebUtilities.attemptRender(res, "Obj", logger);

    // Assert
    verify(res).body("\"Obj\"");
  }

  /**
   * Test {@link WebUtilities#attemptRender(Response, Object, Logger)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then calls {@link Response#body(String)}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#attemptRender(Response, Object, Logger)}
   */
  @Test
  @DisplayName("Test attemptRender(Response, Object, Logger); when one; then calls body(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebUtilities.attemptRender(Response, Object, Logger)"})
  void testAttemptRender_whenOne_thenCallsBody() {
    // Arrange
    Response res = mock(Response.class);
    doNothing().when(res).body(Mockito.<String>any());
    SubstituteLogger logger = new SubstituteLogger("Name", new LinkedList<>(), true);

    // Act
    WebUtilities.attemptRender(res, 1, logger);

    // Assert
    verify(res).body("1");
  }

  /**
   * Test {@link WebUtilities#attemptRender(Response, Object, Logger)}.
   *
   * <ul>
   *   <li>When {@link Response} {@link Response#body(String)} does nothing.
   *   <li>Then calls {@link Response#body(String)}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#attemptRender(Response, Object, Logger)}
   */
  @Test
  @DisplayName(
      "Test attemptRender(Response, Object, Logger); when Response body(String) does nothing; then calls body(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebUtilities.attemptRender(Response, Object, Logger)"})
  void testAttemptRender_whenResponseBodyDoesNothing_thenCallsBody() {
    // Arrange
    Response res = mock(Response.class);
    doNothing().when(res).body(Mockito.<String>any());
    SubstituteLogger logger = new SubstituteLogger("Name", new LinkedList<>(), true);

    // Act
    WebUtilities.attemptRender(res, "Obj", logger);

    // Assert
    verify(res).body("\"Obj\"");
  }

  /**
   * Test {@link WebUtilities#getLong(Request, String)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link Request} {@link Request#params(String)} return {@code 42}.
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#getLong(Request, String)}
   */
  @Test
  @DisplayName(
      "Test getLong(Request, String); given '42'; when Request params(String) return '42'; then return forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long WebUtilities.getLong(Request, String)"})
  void testGetLong_given42_whenRequestParamsReturn42_thenReturnFortyTwo() {
    // Arrange
    Request request = mock(Request.class);
    when(request.params(Mockito.<String>any())).thenReturn("42");

    // Act
    long actualLong = WebUtilities.getLong(request, "Param Name");

    // Assert
    verify(request).params("Param Name");
    assertEquals(42L, actualLong);
  }

  /**
   * Test {@link WebUtilities#getLong(Request, String)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#getLong(Request, String)}
   */
  @Test
  @DisplayName(
      "Test getLong(Request, String); given IllegalArgumentException(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long WebUtilities.getLong(Request, String)"})
  void testGetLong_givenIllegalArgumentException_thenThrowIllegalArgumentException() {
    // Arrange
    Request request = mock(Request.class);
    when(request.params(Mockito.<String>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> WebUtilities.getLong(request, "Param Name"));
    verify(request).params("Param Name");
  }

  /**
   * Test {@link WebUtilities#getInt(Request, String)}.
   *
   * <ul>
   *   <li>Given {@code 1}.
   *   <li>When {@link Request} {@link Request#params(String)} return {@code 1}.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#getInt(Request, String)}
   */
  @Test
  @DisplayName(
      "Test getInt(Request, String); given '1'; when Request params(String) return '1'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int WebUtilities.getInt(Request, String)"})
  void testGetInt_given1_whenRequestParamsReturn1_thenReturnOne() {
    // Arrange
    Request request = mock(Request.class);
    when(request.params(Mockito.<String>any())).thenReturn("1");

    // Act
    int actualInt = WebUtilities.getInt(request, "Param Name");

    // Assert
    verify(request).params("Param Name");
    assertEquals(1, actualInt);
  }

  /**
   * Test {@link WebUtilities#getInt(Request, String)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#getInt(Request, String)}
   */
  @Test
  @DisplayName(
      "Test getInt(Request, String); given IllegalArgumentException(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int WebUtilities.getInt(Request, String)"})
  void testGetInt_givenIllegalArgumentException_thenThrowIllegalArgumentException() {
    // Arrange
    Request request = mock(Request.class);
    when(request.params(Mockito.<String>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> WebUtilities.getInt(request, "Param Name"));
    verify(request).params("Param Name");
  }

  /**
   * Test {@link WebUtilities#getId(Request)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link Request} {@link Request#params(String)} return {@code 42}.
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#getId(Request)}
   */
  @Test
  @DisplayName(
      "Test getId(Request); given '42'; when Request params(String) return '42'; then return forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long WebUtilities.getId(Request)"})
  void testGetId_given42_whenRequestParamsReturn42_thenReturnFortyTwo() {
    // Arrange
    Request request = mock(Request.class);
    when(request.params(Mockito.<String>any())).thenReturn("42");

    // Act
    long actualId = WebUtilities.getId(request);

    // Assert
    verify(request).params("id");
    assertEquals(42L, actualId);
  }

  /**
   * Test {@link WebUtilities#getId(Request)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#getId(Request)}
   */
  @Test
  @DisplayName(
      "Test getId(Request); given IllegalArgumentException(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long WebUtilities.getId(Request)"})
  void testGetId_givenIllegalArgumentException_thenThrowIllegalArgumentException() {
    // Arrange
    Request request = mock(Request.class);
    when(request.params(Mockito.<String>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> WebUtilities.getId(request));
    verify(request).params("id");
  }

  /**
   * Test {@link WebUtilities#requireEditRoleForEntity(UserRoleService, Request, EntityKind,
   * Operation, EntityKind)}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#requireEditRoleForEntity(UserRoleService, Request,
   * EntityKind, Operation, EntityKind)}
   */
  @Test
  @DisplayName(
      "Test requireEditRoleForEntity(UserRoleService, Request, EntityKind, Operation, EntityKind); given empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WebUtilities.requireEditRoleForEntity(UserRoleService, Request, EntityKind, Operation, EntityKind)"
  })
  void testRequireEditRoleForEntity_givenEmptyString() {
    // Arrange
    ArrayList<Setting> overrides = new ArrayList<>();
    overrides.add(
        ImmutableSetting.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .value("42")
            .build());
    overrides.add(
        ImmutableSetting.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .value("42")
            .build());
    SettingsService settingsService = new SettingsService(mock(SettingsDao.class), overrides);
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);

    Request req = mock(Request.class);
    when(req.attribute(Mockito.<String>any())).thenReturn("");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            WebUtilities.requireEditRoleForEntity(
                userRoleService, req, EntityKind.ALL, Operation.ADD, EntityKind.ALL));
    verify(req).attribute("waltz-user");
  }

  /**
   * Test {@link WebUtilities#requireEditRoleForEntity(UserRoleService, Request, EntityKind,
   * Operation, EntityKind)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@code APPLICATION}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#requireEditRoleForEntity(UserRoleService, Request,
   * EntityKind, Operation, EntityKind)}
   */
  @Test
  @DisplayName(
      "Test requireEditRoleForEntity(UserRoleService, Request, EntityKind, Operation, EntityKind); given 'false'; when 'APPLICATION'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WebUtilities.requireEditRoleForEntity(UserRoleService, Request, EntityKind, Operation, EntityKind)"
  })
  void testRequireEditRoleForEntity_givenFalse_whenApplication() {
    // Arrange
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), Mockito.<Set<String>>any()))
        .thenReturn(false);

    Request req = mock(Request.class);
    when(req.attribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act and Assert
    assertThrows(
        NotAuthorizedException.class,
        () ->
            WebUtilities.requireEditRoleForEntity(
                userRoleService, req, EntityKind.APPLICATION, Operation.ADD, EntityKind.ALL));
    verify(userRoleService).hasRole(eq("Attribute"), isA(Set.class));
    verify(req).attribute("waltz-user");
  }

  /**
   * Test {@link WebUtilities#requireEditRoleForEntity(UserRoleService, Request, EntityKind,
   * Operation, EntityKind)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@code CHANGE_INITIATIVE}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#requireEditRoleForEntity(UserRoleService, Request,
   * EntityKind, Operation, EntityKind)}
   */
  @Test
  @DisplayName(
      "Test requireEditRoleForEntity(UserRoleService, Request, EntityKind, Operation, EntityKind); given 'false'; when 'CHANGE_INITIATIVE'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WebUtilities.requireEditRoleForEntity(UserRoleService, Request, EntityKind, Operation, EntityKind)"
  })
  void testRequireEditRoleForEntity_givenFalse_whenChangeInitiative() {
    // Arrange
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), Mockito.<Set<String>>any()))
        .thenReturn(false);

    Request req = mock(Request.class);
    when(req.attribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act and Assert
    assertThrows(
        NotAuthorizedException.class,
        () ->
            WebUtilities.requireEditRoleForEntity(
                userRoleService, req, EntityKind.CHANGE_INITIATIVE, Operation.ADD, EntityKind.ALL));
    verify(userRoleService).hasRole(eq("Attribute"), isA(Set.class));
    verify(req).attribute("waltz-user");
  }

  /**
   * Test {@link WebUtilities#requireEditRoleForEntity(UserRoleService, Request, EntityKind,
   * Operation, EntityKind)}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link UserRoleService} {@link UserRoleService#hasRole(String, Set)} return {@code
   *       false}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#requireEditRoleForEntity(UserRoleService, Request,
   * EntityKind, Operation, EntityKind)}
   */
  @Test
  @DisplayName(
      "Test requireEditRoleForEntity(UserRoleService, Request, EntityKind, Operation, EntityKind); given 'false'; when UserRoleService hasRole(String, Set) return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WebUtilities.requireEditRoleForEntity(UserRoleService, Request, EntityKind, Operation, EntityKind)"
  })
  void testRequireEditRoleForEntity_givenFalse_whenUserRoleServiceHasRoleReturnFalse() {
    // Arrange
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), Mockito.<Set<String>>any()))
        .thenReturn(false);

    Request req = mock(Request.class);
    when(req.attribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act and Assert
    assertThrows(
        NotAuthorizedException.class,
        () ->
            WebUtilities.requireEditRoleForEntity(
                userRoleService, req, EntityKind.ALL, Operation.ADD, EntityKind.ALL));
    verify(userRoleService).hasRole(eq("Attribute"), isA(Set.class));
    verify(req).attribute("waltz-user");
  }

  /**
   * Test {@link WebUtilities#requireEditRoleForEntity(UserRoleService, Request, EntityKind,
   * Operation, EntityKind)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>Then calls {@link UserRoleDao#getUserRoles(String)}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#requireEditRoleForEntity(UserRoleService, Request,
   * EntityKind, Operation, EntityKind)}
   */
  @Test
  @DisplayName(
      "Test requireEditRoleForEntity(UserRoleService, Request, EntityKind, Operation, EntityKind); given HashSet(); then calls getUserRoles(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WebUtilities.requireEditRoleForEntity(UserRoleService, Request, EntityKind, Operation, EntityKind)"
  })
  void testRequireEditRoleForEntity_givenHashSet_thenCallsGetUserRoles() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());

    ArrayList<Setting> overrides = new ArrayList<>();
    overrides.add(
        ImmutableSetting.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .value("42")
            .build());
    overrides.add(
        ImmutableSetting.builder()
            .description("The characteristics of someone or something")
            .name("Name")
            .value("42")
            .build());
    SettingsService settingsService = new SettingsService(mock(SettingsDao.class), overrides);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);

    Request req = mock(Request.class);
    when(req.attribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act and Assert
    assertThrows(
        NotAuthorizedException.class,
        () ->
            WebUtilities.requireEditRoleForEntity(
                userRoleService, req, EntityKind.ALL, Operation.ADD, EntityKind.ALL));
    verify(userRoleDao).getUserRoles("Attribute");
    verify(req).attribute("waltz-user");
  }

  /**
   * Test {@link WebUtilities#requireEditRoleForEntity(UserRoleService, Request, EntityKind,
   * Operation, EntityKind)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link UserRoleService}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#requireEditRoleForEntity(UserRoleService, Request,
   * EntityKind, Operation, EntityKind)}
   */
  @Test
  @DisplayName(
      "Test requireEditRoleForEntity(UserRoleService, Request, EntityKind, Operation, EntityKind); given 'null'; when UserRoleService")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WebUtilities.requireEditRoleForEntity(UserRoleService, Request, EntityKind, Operation, EntityKind)"
  })
  void testRequireEditRoleForEntity_givenNull_whenUserRoleService() {
    // Arrange
    UserRoleService userRoleService = mock(UserRoleService.class);

    Request req = mock(Request.class);
    when(req.attribute(Mockito.<String>any())).thenReturn(null);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            WebUtilities.requireEditRoleForEntity(
                userRoleService, req, EntityKind.ALL, Operation.ADD, EntityKind.ALL));
    verify(req).attribute("waltz-user");
  }

  /**
   * Test {@link WebUtilities#requireEditRoleForEntity(UserRoleService, Request, EntityKind,
   * Operation, EntityKind)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link UserRoleService} {@link UserRoleService#hasRole(String, Set)} return {@code
   *       true}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#requireEditRoleForEntity(UserRoleService, Request,
   * EntityKind, Operation, EntityKind)}
   */
  @Test
  @DisplayName(
      "Test requireEditRoleForEntity(UserRoleService, Request, EntityKind, Operation, EntityKind); given 'true'; when UserRoleService hasRole(String, Set) return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void WebUtilities.requireEditRoleForEntity(UserRoleService, Request, EntityKind, Operation, EntityKind)"
  })
  void testRequireEditRoleForEntity_givenTrue_whenUserRoleServiceHasRoleReturnTrue() {
    // Arrange
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), Mockito.<Set<String>>any()))
        .thenReturn(true);

    Request req = mock(Request.class);
    when(req.attribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act
    WebUtilities.requireEditRoleForEntity(
        userRoleService, req, EntityKind.ALL, Operation.ADD, EntityKind.ALL);

    // Assert
    verify(userRoleService).hasRole(eq("Attribute"), isA(Set.class));
    verify(req).attribute("waltz-user");
  }

  /**
   * Test {@link WebUtilities#requireRole(UserRoleService, Request, Set)} with {@code
   * UserRoleService}, {@code Request}, {@code Set}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>Then calls {@link UserRoleService#hasRole(String, Set)}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#requireRole(UserRoleService, Request, Set)}
   */
  @Test
  @DisplayName(
      "Test requireRole(UserRoleService, Request, Set) with 'UserRoleService', 'Request', 'Set'; given 'false'; then calls hasRole(String, Set)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebUtilities.requireRole(UserRoleService, Request, Set)"})
  void testRequireRoleWithUserRoleServiceRequestSet_givenFalse_thenCallsHasRole() {
    // Arrange
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), Mockito.<Set<String>>any()))
        .thenReturn(false);

    Request request = mock(Request.class);
    when(request.attribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act and Assert
    assertThrows(
        NotAuthorizedException.class,
        () -> WebUtilities.requireRole(userRoleService, request, new HashSet<>()));
    verify(userRoleService).hasRole(eq("Attribute"), isA(Set.class));
    verify(request).attribute("waltz-user");
  }

  /**
   * Test {@link WebUtilities#requireRole(UserRoleService, Request, Set)} with {@code
   * UserRoleService}, {@code Request}, {@code Set}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>Then calls {@link UserRoleDao#getUserRoles(String)}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#requireRole(UserRoleService, Request, Set)}
   */
  @Test
  @DisplayName(
      "Test requireRole(UserRoleService, Request, Set) with 'UserRoleService', 'Request', 'Set'; given HashSet(); then calls getUserRoles(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebUtilities.requireRole(UserRoleService, Request, Set)"})
  void testRequireRoleWithUserRoleServiceRequestSet_givenHashSet_thenCallsGetUserRoles() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);

    Request request = mock(Request.class);
    when(request.attribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act
    WebUtilities.requireRole(userRoleService, request, new HashSet<>());

    // Assert
    verify(userRoleDao).getUserRoles("Attribute");
    verify(request).attribute("waltz-user");
  }

  /**
   * Test {@link WebUtilities#requireRole(UserRoleService, Request, Set)} with {@code
   * UserRoleService}, {@code Request}, {@code Set}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#requireRole(UserRoleService, Request, Set)}
   */
  @Test
  @DisplayName(
      "Test requireRole(UserRoleService, Request, Set) with 'UserRoleService', 'Request', 'Set'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebUtilities.requireRole(UserRoleService, Request, Set)"})
  void testRequireRoleWithUserRoleServiceRequestSet_thenThrowIllegalArgumentException() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);

    Request request = mock(Request.class);
    when(request.attribute(Mockito.<String>any())).thenReturn("");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> WebUtilities.requireRole(userRoleService, request, new HashSet<>()));
    verify(request).attribute("waltz-user");
  }

  /**
   * Test {@link WebUtilities#requireRole(UserRoleService, Request, Set)} with {@code
   * UserRoleService}, {@code Request}, {@code Set}.
   *
   * <ul>
   *   <li>When {@link HashSet#HashSet()} add {@code Attribute}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#requireRole(UserRoleService, Request, Set)}
   */
  @Test
  @DisplayName(
      "Test requireRole(UserRoleService, Request, Set) with 'UserRoleService', 'Request', 'Set'; when HashSet() add 'Attribute'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebUtilities.requireRole(UserRoleService, Request, Set)"})
  void testRequireRoleWithUserRoleServiceRequestSet_whenHashSetAddAttribute() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);

    Request request = mock(Request.class);
    when(request.attribute(Mockito.<String>any())).thenReturn("Attribute");

    HashSet<String> requiredRoles = new HashSet<>();
    requiredRoles.add("Attribute");

    // Act and Assert
    assertThrows(
        NotAuthorizedException.class,
        () -> WebUtilities.requireRole(userRoleService, request, requiredRoles));
    verify(userRoleDao).getUserRoles("Attribute");
    verify(request).attribute("waltz-user");
  }

  /**
   * Test {@link WebUtilities#requireRole(UserRoleService, Request, String[])} with {@code
   * UserRoleService}, {@code Request}, {@code String[]}.
   *
   * <p>Method under test: {@link WebUtilities#requireRole(UserRoleService, Request, String[])}
   */
  @Test
  @DisplayName(
      "Test requireRole(UserRoleService, Request, String[]) with 'UserRoleService', 'Request', 'String[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebUtilities.requireRole(UserRoleService, Request, String[])"})
  void testRequireRoleWithUserRoleServiceRequestString() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);

    Request request = mock(Request.class);
    when(request.attribute(Mockito.<String>any())).thenReturn("");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> WebUtilities.requireRole(userRoleService, request, "Required Roles"));
    verify(request).attribute("waltz-user");
  }

  /**
   * Test {@link WebUtilities#requireRole(UserRoleService, Request, String[])} with {@code
   * UserRoleService}, {@code Request}, {@code String[]}.
   *
   * <ul>
   *   <li>Given {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#requireRole(UserRoleService, Request, String[])}
   */
  @Test
  @DisplayName(
      "Test requireRole(UserRoleService, Request, String[]) with 'UserRoleService', 'Request', 'String[]'; given 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebUtilities.requireRole(UserRoleService, Request, String[])"})
  void testRequireRoleWithUserRoleServiceRequestString_givenFalse() {
    // Arrange
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), Mockito.<Set<String>>any()))
        .thenReturn(false);

    Request request = mock(Request.class);
    when(request.attribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act and Assert
    assertThrows(
        NotAuthorizedException.class,
        () -> WebUtilities.requireRole(userRoleService, request, "Required Roles"));
    verify(userRoleService).hasRole(eq("Attribute"), isA(Set.class));
    verify(request).attribute("waltz-user");
  }

  /**
   * Test {@link WebUtilities#requireRole(UserRoleService, Request, String[])} with {@code
   * UserRoleService}, {@code Request}, {@code String[]}.
   *
   * <ul>
   *   <li>Given {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#requireRole(UserRoleService, Request, String[])}
   */
  @Test
  @DisplayName(
      "Test requireRole(UserRoleService, Request, String[]) with 'UserRoleService', 'Request', 'String[]'; given 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebUtilities.requireRole(UserRoleService, Request, String[])"})
  void testRequireRoleWithUserRoleServiceRequestString_givenTrue() {
    // Arrange
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), Mockito.<Set<String>>any()))
        .thenReturn(true);

    Request request = mock(Request.class);
    when(request.attribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act
    WebUtilities.requireRole(userRoleService, request, "Required Roles");

    // Assert
    verify(userRoleService).hasRole(eq("Attribute"), isA(Set.class));
    verify(request).attribute("waltz-user");
  }

  /**
   * Test {@link WebUtilities#requireRole(UserRoleService, Request, String[])} with {@code
   * UserRoleService}, {@code Request}, {@code String[]}.
   *
   * <ul>
   *   <li>Given {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#requireRole(UserRoleService, Request, String[])}
   */
  @Test
  @DisplayName(
      "Test requireRole(UserRoleService, Request, String[]) with 'UserRoleService', 'Request', 'String[]'; given 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebUtilities.requireRole(UserRoleService, Request, String[])"})
  void testRequireRoleWithUserRoleServiceRequestString_givenTrue2() {
    // Arrange
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), Mockito.<Set<String>>any()))
        .thenReturn(true);

    Request request = mock(Request.class);
    when(request.attribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act
    WebUtilities.requireRole(userRoleService, request, new String[] {});

    // Assert
    verify(userRoleService).hasRole(eq("Attribute"), isA(Set.class));
    verify(request).attribute("waltz-user");
  }

  /**
   * Test {@link WebUtilities#requireRole(UserRoleService, Request, String[])} with {@code
   * UserRoleService}, {@code Request}, {@code String[]}.
   *
   * <ul>
   *   <li>Then calls {@link UserRoleDao#getUserRoles(String)}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#requireRole(UserRoleService, Request, String[])}
   */
  @Test
  @DisplayName(
      "Test requireRole(UserRoleService, Request, String[]) with 'UserRoleService', 'Request', 'String[]'; then calls getUserRoles(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebUtilities.requireRole(UserRoleService, Request, String[])"})
  void testRequireRoleWithUserRoleServiceRequestString_thenCallsGetUserRoles() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);

    Request request = mock(Request.class);
    when(request.attribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act and Assert
    assertThrows(
        NotAuthorizedException.class,
        () -> WebUtilities.requireRole(userRoleService, request, "Required Roles"));
    verify(userRoleDao).getUserRoles("Attribute");
    verify(request).attribute("waltz-user");
  }

  /**
   * Test {@link WebUtilities#requireAnyRole(UserRoleService, Request, SystemRole[])}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#requireAnyRole(UserRoleService, Request,
   * SystemRole[])}
   */
  @Test
  @DisplayName(
      "Test requireAnyRole(UserRoleService, Request, SystemRole[]); given empty string; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebUtilities.requireAnyRole(UserRoleService, Request, SystemRole[])"})
  void testRequireAnyRole_givenEmptyString_thenThrowIllegalArgumentException() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);

    Request request = mock(Request.class);
    when(request.attribute(Mockito.<String>any())).thenReturn("");

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> WebUtilities.requireAnyRole(userRoleService, request, SystemRole.ACTOR_ADMIN));
    verify(request).attribute("waltz-user");
  }

  /**
   * Test {@link WebUtilities#requireAnyRole(UserRoleService, Request, SystemRole[])}.
   *
   * <ul>
   *   <li>Given {@code false}.
   *   <li>When {@link UserRoleService} {@link UserRoleService#hasAnyRole(String, SystemRole[])}
   *       return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#requireAnyRole(UserRoleService, Request,
   * SystemRole[])}
   */
  @Test
  @DisplayName(
      "Test requireAnyRole(UserRoleService, Request, SystemRole[]); given 'false'; when UserRoleService hasAnyRole(String, SystemRole[]) return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebUtilities.requireAnyRole(UserRoleService, Request, SystemRole[])"})
  void testRequireAnyRole_givenFalse_whenUserRoleServiceHasAnyRoleReturnFalse() {
    // Arrange
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasAnyRole(Mockito.<String>any(), (SystemRole[]) Mockito.any()))
        .thenReturn(false);

    Request request = mock(Request.class);
    when(request.attribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act and Assert
    assertThrows(
        NotAuthorizedException.class,
        () -> WebUtilities.requireAnyRole(userRoleService, request, SystemRole.ACTOR_ADMIN));
    verify(userRoleService).hasAnyRole(eq("Attribute"), (SystemRole[]) Mockito.any());
    verify(request).attribute("waltz-user");
  }

  /**
   * Test {@link WebUtilities#requireAnyRole(UserRoleService, Request, SystemRole[])}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>Then calls {@link UserRoleDao#getUserRoles(String)}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#requireAnyRole(UserRoleService, Request,
   * SystemRole[])}
   */
  @Test
  @DisplayName(
      "Test requireAnyRole(UserRoleService, Request, SystemRole[]); given HashSet(); then calls getUserRoles(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebUtilities.requireAnyRole(UserRoleService, Request, SystemRole[])"})
  void testRequireAnyRole_givenHashSet_thenCallsGetUserRoles() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);

    Request request = mock(Request.class);
    when(request.attribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act and Assert
    assertThrows(
        NotAuthorizedException.class,
        () -> WebUtilities.requireAnyRole(userRoleService, request, SystemRole.ACTOR_ADMIN));
    verify(userRoleDao).getUserRoles("Attribute");
    verify(request).attribute("waltz-user");
  }

  /**
   * Test {@link WebUtilities#requireAnyRole(UserRoleService, Request, SystemRole[])}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>Then calls {@link UserRoleDao#getUserRoles(String)}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#requireAnyRole(UserRoleService, Request,
   * SystemRole[])}
   */
  @Test
  @DisplayName(
      "Test requireAnyRole(UserRoleService, Request, SystemRole[]); given HashSet(); then calls getUserRoles(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebUtilities.requireAnyRole(UserRoleService, Request, SystemRole[])"})
  void testRequireAnyRole_givenHashSet_thenCallsGetUserRoles2() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService =
        new ChangeLogService(
            mock(ChangeLogDao.class),
            mock(ChangeLogSummariesDao.class),
            mock(PhysicalFlowDao.class),
            mock(PhysicalSpecificationDao.class),
            mock(LogicalFlowDao.class),
            mock(ApplicationDao.class),
            mock(MeasurableRatingReplacementDao.class),
            mock(MeasurableRatingDao.class),
            mock(MeasurableRatingPlannedDecommissionDao.class),
            mock(EntityReferenceNameResolver.class));
    PersonService personService =
        new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));
    SettingsDao settingsDao = mock(SettingsDao.class);
    SettingsService settingsService = new SettingsService(settingsDao, new ArrayList<>());

    UserRoleService userRoleService =
        new UserRoleService(
            userRoleDao, roleDao, personDao, changeLogService, personService, settingsService);

    Request request = mock(Request.class);
    when(request.attribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act and Assert
    assertThrows(
        NotAuthorizedException.class, () -> WebUtilities.requireAnyRole(userRoleService, request));
    verify(userRoleDao).getUserRoles("Attribute");
    verify(request).attribute("waltz-user");
  }

  /**
   * Test {@link WebUtilities#requireAnyRole(UserRoleService, Request, SystemRole[])}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link UserRoleService} {@link UserRoleService#hasAnyRole(String, SystemRole[])}
   *       return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#requireAnyRole(UserRoleService, Request,
   * SystemRole[])}
   */
  @Test
  @DisplayName(
      "Test requireAnyRole(UserRoleService, Request, SystemRole[]); given 'true'; when UserRoleService hasAnyRole(String, SystemRole[]) return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebUtilities.requireAnyRole(UserRoleService, Request, SystemRole[])"})
  void testRequireAnyRole_givenTrue_whenUserRoleServiceHasAnyRoleReturnTrue() {
    // Arrange
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasAnyRole(Mockito.<String>any(), (SystemRole[]) Mockito.any()))
        .thenReturn(true);

    Request request = mock(Request.class);
    when(request.attribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act
    WebUtilities.requireAnyRole(userRoleService, request, SystemRole.ACTOR_ADMIN);

    // Assert
    verify(userRoleService).hasAnyRole(eq("Attribute"), (SystemRole[]) Mockito.any());
    verify(request).attribute("waltz-user");
  }

  /**
   * Test {@link WebUtilities#getUsername(Request)}.
   *
   * <ul>
   *   <li>Given {@code Attribute}.
   *   <li>Then return {@code Attribute}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#getUsername(Request)}
   */
  @Test
  @DisplayName("Test getUsername(Request); given 'Attribute'; then return 'Attribute'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.getUsername(Request)"})
  void testGetUsername_givenAttribute_thenReturnAttribute() {
    // Arrange
    Request request = mock(Request.class);
    when(request.attribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act
    String actualUsername = WebUtilities.getUsername(request);

    // Assert
    verify(request).attribute("waltz-user");
    assertEquals("Attribute", actualUsername);
  }

  /**
   * Test {@link WebUtilities#getKind(Request, String)} with {@code request}, {@code paramName}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#getKind(Request, String)}
   */
  @Test
  @DisplayName(
      "Test getKind(Request, String) with 'request', 'paramName'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind WebUtilities.getKind(Request, String)"})
  void testGetKindWithRequestParamName_thenThrowIllegalArgumentException() {
    // Arrange
    Request request = mock(Request.class);
    when(request.params(Mockito.<String>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> WebUtilities.getKind(request, "Param Name"));
    verify(request).params("Param Name");
  }

  /**
   * Test {@link WebUtilities#getKind(Request)} with {@code request}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#getKind(Request)}
   */
  @Test
  @DisplayName("Test getKind(Request) with 'request'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind WebUtilities.getKind(Request)"})
  void testGetKindWithRequest_thenThrowIllegalArgumentException() {
    // Arrange
    Request request = mock(Request.class);
    when(request.params(Mockito.<String>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> WebUtilities.getKind(request));
    verify(request).params("kind");
  }

  /**
   * Test {@link WebUtilities#readBody(Request, Class, Object)} with {@code request}, {@code
   * objClass}, {@code dflt}.
   *
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code Dflt}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#readBody(Request, Class, Object)}
   */
  @Test
  @DisplayName(
      "Test readBody(Request, Class, Object) with 'request', 'objClass', 'dflt'; given 'AXAXAXAX' Bytes is 'UTF-8'; then return 'Dflt'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object WebUtilities.readBody(Request, Class, Object)"})
  void testReadBodyWithRequestObjClassDflt_givenAxaxaxaxBytesIsUtf8_thenReturnDflt()
      throws UnsupportedEncodingException {
    // Arrange
    Request request = mock(Request.class);
    when(request.bodyAsBytes()).thenReturn("AXAXAXAX".getBytes("UTF-8"));
    Class<Object> objClass = Object.class;

    // Act
    Object actualReadBodyResult = WebUtilities.readBody(request, objClass, "Dflt");

    // Assert
    verify(request).bodyAsBytes();
    assertEquals("Dflt", actualReadBodyResult);
  }

  /**
   * Test {@link WebUtilities#readBody(Request, Class, Object)} with {@code request}, {@code
   * objClass}, {@code dflt}.
   *
   * <ul>
   *   <li>Given empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#readBody(Request, Class, Object)}
   */
  @Test
  @DisplayName(
      "Test readBody(Request, Class, Object) with 'request', 'objClass', 'dflt'; given empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object WebUtilities.readBody(Request, Class, Object)"})
  void testReadBodyWithRequestObjClassDflt_givenEmptyArrayOfByte() {
    // Arrange
    Request request = mock(Request.class);
    when(request.bodyAsBytes()).thenReturn(new byte[] {});
    Class<Object> objClass = Object.class;

    // Act
    Object actualReadBodyResult = WebUtilities.readBody(request, objClass, "Dflt");

    // Assert
    verify(request).bodyAsBytes();
    assertEquals("Dflt", actualReadBodyResult);
  }

  /**
   * Test {@link WebUtilities#readEnum(Request, String, Class, Function)}.
   *
   * <ul>
   *   <li>Given {@code Params}.
   *   <li>When {@link Function} {@link Function#apply(Object)} return {@code CONSTANT_ASCENT}.
   *   <li>Then calls {@link Function#apply(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#readEnum(Request, String, Class, Function)}
   */
  @Test
  @DisplayName(
      "Test readEnum(Request, String, Class, Function); given 'Params'; when Function apply(Object) return 'CONSTANT_ASCENT'; then calls apply(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Enum WebUtilities.readEnum(Request, String, Class, Function)"})
  void testReadEnum_givenParams_whenFunctionApplyReturnConstantAscent_thenCallsApply() {
    // Arrange
    Request request = mock(Request.class);
    when(request.params(Mockito.<String>any())).thenReturn("Params");
    Class<BaselineResizeBehavior> enumClass = BaselineResizeBehavior.class;

    Function<String, BaselineResizeBehavior> failedParseSupplier = mock(Function.class);
    when(failedParseSupplier.apply(Mockito.<String>any()))
        .thenReturn(BaselineResizeBehavior.CONSTANT_ASCENT);

    // Act
    BaselineResizeBehavior actualReadEnumResult =
        WebUtilities.readEnum(request, "Param Name", enumClass, failedParseSupplier);

    // Assert
    verify(failedParseSupplier).apply("Params");
    verify(request).params("Param Name");
    assertEquals(BaselineResizeBehavior.CONSTANT_ASCENT, actualReadEnumResult);
  }

  /**
   * Test {@link WebUtilities#readEnum(Request, String, Class, Function)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#readEnum(Request, String, Class, Function)}
   */
  @Test
  @DisplayName(
      "Test readEnum(Request, String, Class, Function); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Enum WebUtilities.readEnum(Request, String, Class, Function)"})
  void testReadEnum_thenThrowIllegalArgumentException() {
    // Arrange
    Request request = mock(Request.class);
    when(request.params(Mockito.<String>any())).thenThrow(new IllegalArgumentException());
    Class<BaselineResizeBehavior> enumClass = BaselineResizeBehavior.class;

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> WebUtilities.readEnum(request, "Param Name", enumClass, mock(Function.class)));
    verify(request).params("Param Name");
  }

  /**
   * Test {@link WebUtilities#readEnum(Request, String, Class, Function)}.
   *
   * <ul>
   *   <li>When {@link Request} {@link Request#params(String)} return {@code CONSTANT_ASCENT}.
   *   <li>Then return {@code CONSTANT_ASCENT}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#readEnum(Request, String, Class, Function)}
   */
  @Test
  @DisplayName(
      "Test readEnum(Request, String, Class, Function); when Request params(String) return 'CONSTANT_ASCENT'; then return 'CONSTANT_ASCENT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Enum WebUtilities.readEnum(Request, String, Class, Function)"})
  void testReadEnum_whenRequestParamsReturnConstantAscent_thenReturnConstantAscent() {
    // Arrange
    Request request = mock(Request.class);
    when(request.params(Mockito.<String>any())).thenReturn("CONSTANT_ASCENT");
    Class<BaselineResizeBehavior> enumClass = BaselineResizeBehavior.class;

    // Act
    BaselineResizeBehavior actualReadEnumResult =
        WebUtilities.readEnum(request, "Param Name", enumClass, mock(Function.class));

    // Assert
    verify(request).params("Param Name");
    assertEquals(BaselineResizeBehavior.CONSTANT_ASCENT, actualReadEnumResult);
  }

  /**
   * Test {@link WebUtilities#reportException(int, String, String, Response, Logger)} with {@code
   * statusCode}, {@code errorCode}, {@code message}, {@code res}, {@code log}.
   *
   * <ul>
   *   <li>Then calls {@link Response#body(String)}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#reportException(int, String, String, Response,
   * Logger)}
   */
  @Test
  @DisplayName(
      "Test reportException(int, String, String, Response, Logger) with 'statusCode', 'errorCode', 'message', 'res', 'log'; then calls body(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebUtilities.reportException(int, String, String, Response, Logger)"})
  void testReportExceptionWithStatusCodeErrorCodeMessageResLog_thenCallsBody() {
    // Arrange
    Response res = mock(Response.class);
    doNothing().when(res).body(Mockito.<String>any());
    doNothing().when(res).status(anyInt());
    SubstituteLogger log = new SubstituteLogger("Name", new LinkedList<>(), true);

    // Act
    WebUtilities.reportException(1, "An error occurred", "An error occurred", res, log);

    // Assert
    verify(res).body("{\"message\":\"An error occurred\",\"id\":\"An error occurred\"}");
    verify(res).status(1);
  }

  /**
   * Test {@link WebUtilities#reportException(int, Optional, String, Response, Logger)} with {@code
   * statusCode}, {@code maybeErrorCode}, {@code message}, {@code res}, {@code log}.
   *
   * <ul>
   *   <li>Then calls {@link Response#body(String)}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#reportException(int, Optional, String, Response,
   * Logger)}
   */
  @Test
  @DisplayName(
      "Test reportException(int, Optional, String, Response, Logger) with 'statusCode', 'maybeErrorCode', 'message', 'res', 'log'; then calls body(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void WebUtilities.reportException(int, Optional, String, Response, Logger)"})
  void testReportExceptionWithStatusCodeMaybeErrorCodeMessageResLog_thenCallsBody() {
    // Arrange
    Optional<String> maybeErrorCode = Optional.of("42");

    Response res = mock(Response.class);
    doNothing().when(res).body(Mockito.<String>any());
    doNothing().when(res).status(anyInt());
    SubstituteLogger log = new SubstituteLogger("Name", new LinkedList<>(), true);

    // Act
    WebUtilities.reportException(1, maybeErrorCode, "An error occurred", res, log);

    // Assert
    verify(res).body("{\"message\":\"An error occurred\",\"id\":\"42\"}");
    verify(res).status(1);
  }

  /**
   * Test {@link WebUtilities#getMimeType(String)}.
   *
   * <ul>
   *   <li>When {@code Path}.
   *   <li>Then return {@code application/octet-stream}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#getMimeType(String)}
   */
  @Test
  @DisplayName("Test getMimeType(String); when 'Path'; then return 'application/octet-stream'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.getMimeType(String)"})
  void testGetMimeType_whenPath_thenReturnApplicationOctetStream() {
    // Arrange, Act and Assert
    assertEquals("application/octet-stream", WebUtilities.getMimeType("Path"));
  }

  /**
   * Test {@link WebUtilities#getMimeType(String)}.
   *
   * <ul>
   *   <li>When {@code ttf}.
   *   <li>Then return {@code application/x-font-ttf}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#getMimeType(String)}
   */
  @Test
  @DisplayName("Test getMimeType(String); when 'ttf'; then return 'application/x-font-ttf'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String WebUtilities.getMimeType(String)"})
  void testGetMimeType_whenTtf_thenReturnApplicationXFontTtf() {
    // Arrange, Act and Assert
    assertEquals("application/x-font-ttf", WebUtilities.getMimeType("ttf"));
  }

  /**
   * Test {@link WebUtilities#getLimit(Request)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#getLimit(Request)}
   */
  @Test
  @DisplayName(
      "Test getLimit(Request); given IllegalArgumentException(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional WebUtilities.getLimit(Request)"})
  void testGetLimit_givenIllegalArgumentException_thenThrowIllegalArgumentException() {
    // Arrange
    Request request = mock(Request.class);
    when(request.queryParams(Mockito.<String>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> WebUtilities.getLimit(request));
    verify(request).queryParams("limit");
  }

  /**
   * Test {@link WebUtilities#getLimit(Request)}.
   *
   * <ul>
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@code limit}
   *       and {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#getLimit(Request)}
   */
  @Test
  @DisplayName(
      "Test getLimit(Request); when MockHttpServletRequest() addParameter 'limit' and '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional WebUtilities.getLimit(Request)"})
  void testGetLimit_whenMockHttpServletRequestAddParameterLimitAnd42() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("limit", "42");

    // Act
    Optional<Integer> actualLimit = WebUtilities.getLimit(RequestResponseFactory.create(request));

    // Assert
    assertEquals(42, actualLimit.get().intValue());
    assertTrue(actualLimit.isPresent());
  }

  /**
   * Test {@link WebUtilities#getLimit(Request)}.
   *
   * <ul>
   *   <li>When {@link Request} {@link Request#queryParams(String)} return {@code 42}.
   *   <li>Then return {@link Optional#get()} intValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#getLimit(Request)}
   */
  @Test
  @DisplayName(
      "Test getLimit(Request); when Request queryParams(String) return '42'; then return get() intValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional WebUtilities.getLimit(Request)"})
  void testGetLimit_whenRequestQueryParamsReturn42_thenReturnGetIntValueIsFortyTwo() {
    // Arrange
    Request request = mock(Request.class);
    when(request.queryParams(Mockito.<String>any())).thenReturn("42");

    // Act
    Optional<Integer> actualLimit = WebUtilities.getLimit(request);

    // Assert
    verify(request).queryParams("limit");
    assertEquals(42, actualLimit.get().intValue());
    assertTrue(actualLimit.isPresent());
  }

  /**
   * Test {@link WebUtilities#getDateParam(Request)}.
   *
   * <ul>
   *   <li>Given {@code date}.
   *   <li>When {@link MockHttpServletRequest#MockHttpServletRequest()} addParameter {@code date}
   *       and {@code Request}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#getDateParam(Request)}
   */
  @Test
  @DisplayName(
      "Test getDateParam(Request); given 'date'; when MockHttpServletRequest() addParameter 'date' and 'Request'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional WebUtilities.getDateParam(Request)"})
  void testGetDateParam_givenDate_whenMockHttpServletRequestAddParameterDateAndRequest() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("date", "Request");

    // Act
    Optional<Date> actualDateParam =
        WebUtilities.getDateParam(RequestResponseFactory.create(request));

    // Assert
    assertFalse(actualDateParam.isPresent());
  }

  /**
   * Test {@link WebUtilities#getDateParam(Request)}.
   *
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#getDateParam(Request)}
   */
  @Test
  @DisplayName(
      "Test getDateParam(Request); given IllegalArgumentException(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional WebUtilities.getDateParam(Request)"})
  void testGetDateParam_givenIllegalArgumentException_thenThrowIllegalArgumentException() {
    // Arrange
    Request request = mock(Request.class);
    when(request.queryParams(Mockito.<String>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> WebUtilities.getDateParam(request));
    verify(request).queryParams("date");
  }

  /**
   * Test {@link WebUtilities#getDateParam(Request)}.
   *
   * <ul>
   *   <li>Given {@code Query Params}.
   *   <li>When {@link Request} {@link Request#queryParams(String)} return {@code Query Params}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#getDateParam(Request)}
   */
  @Test
  @DisplayName(
      "Test getDateParam(Request); given 'Query Params'; when Request queryParams(String) return 'Query Params'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional WebUtilities.getDateParam(Request)"})
  void testGetDateParam_givenQueryParams_whenRequestQueryParamsReturnQueryParams() {
    // Arrange
    Request request = mock(Request.class);
    when(request.queryParams(Mockito.<String>any())).thenReturn("Query Params");

    // Act
    Optional<Date> actualDateParam = WebUtilities.getDateParam(request);

    // Assert
    verify(request).queryParams("date");
    assertFalse(actualDateParam.isPresent());
  }

  /**
   * Test {@link WebUtilities#getDateParam(Request)}.
   *
   * <ul>
   *   <li>Given {@code yyyy-MM-dd}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#getDateParam(Request)}
   */
  @Test
  @DisplayName("Test getDateParam(Request); given 'yyyy-MM-dd'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional WebUtilities.getDateParam(Request)"})
  void testGetDateParam_givenYyyyMmDd() {
    // Arrange
    MockHttpServletRequest request = new MockHttpServletRequest();
    request.addParameter("yyyy-MM-dd", "Request");

    // Act
    Optional<Date> actualDateParam =
        WebUtilities.getDateParam(RequestResponseFactory.create(request));

    // Assert
    assertFalse(actualDateParam.isPresent());
  }

  /**
   * Test {@link WebUtilities#getLocalDateParam(Request, String)}.
   *
   * <ul>
   *   <li>Given {@code Params}.
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#getLocalDateParam(Request, String)}
   */
  @Test
  @DisplayName("Test getLocalDateParam(Request, String); given 'Params'; then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional WebUtilities.getLocalDateParam(Request, String)"})
  void testGetLocalDateParam_givenParams_thenReturnNotPresent() {
    // Arrange
    Request request = mock(Request.class);
    when(request.params(Mockito.<String>any())).thenReturn("Params");

    // Act
    Optional<LocalDate> actualLocalDateParam =
        WebUtilities.getLocalDateParam(request, "Param Name");

    // Assert
    verify(request).params("Param Name");
    assertFalse(actualLocalDateParam.isPresent());
  }

  /**
   * Test {@link WebUtilities#getLocalDateParam(Request, String)}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#getLocalDateParam(Request, String)}
   */
  @Test
  @DisplayName("Test getLocalDateParam(Request, String); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional WebUtilities.getLocalDateParam(Request, String)"})
  void testGetLocalDateParam_thenThrowIllegalArgumentException() {
    // Arrange
    Request request = mock(Request.class);
    when(request.params(Mockito.<String>any())).thenThrow(new IllegalArgumentException());

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> WebUtilities.getLocalDateParam(request, "Param Name"));
    verify(request).params("Param Name");
  }

  /**
   * Test {@link WebUtilities#simplifyMapToList(Map)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link HashMap#HashMap()} {@code 42} is {@code Value}.
   *   <li>Then return size is two.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#simplifyMapToList(Map)}
   */
  @Test
  @DisplayName(
      "Test simplifyMapToList(Map); given '42'; when HashMap() '42' is 'Value'; then return size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List WebUtilities.simplifyMapToList(Map)"})
  void testSimplifyMapToList_given42_whenHashMap42IsValue_thenReturnSizeIsTwo() {
    // Arrange
    HashMap<Object, Object> m = new HashMap<>();
    m.put("42", "Value");
    m.put("Key", "Value");

    // Act
    List<Entry<Object, Object>> actualSimplifyMapToListResult = WebUtilities.simplifyMapToList(m);

    // Assert
    assertEquals(2, actualSimplifyMapToListResult.size());
    Entry<Object, Object> getResult = actualSimplifyMapToListResult.get(0);
    assertTrue(getResult instanceof ImmutableEntry);
    Entry<Object, Object> getResult2 = actualSimplifyMapToListResult.get(1);
    assertTrue(getResult2 instanceof ImmutableEntry);
    assertEquals("42", getResult.key());
    assertEquals("Key", getResult2.key());
    assertEquals("Value", getResult2.value());
  }

  /**
   * Test {@link WebUtilities#simplifyMapToList(Map)}.
   *
   * <ul>
   *   <li>Given {@code Key}.
   *   <li>When {@link HashMap#HashMap()} {@code Key} is {@code Value}.
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#simplifyMapToList(Map)}
   */
  @Test
  @DisplayName(
      "Test simplifyMapToList(Map); given 'Key'; when HashMap() 'Key' is 'Value'; then return size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List WebUtilities.simplifyMapToList(Map)"})
  void testSimplifyMapToList_givenKey_whenHashMapKeyIsValue_thenReturnSizeIsOne() {
    // Arrange
    HashMap<Object, Object> m = new HashMap<>();
    m.put("Key", "Value");

    // Act
    List<Entry<Object, Object>> actualSimplifyMapToListResult = WebUtilities.simplifyMapToList(m);

    // Assert
    assertEquals(1, actualSimplifyMapToListResult.size());
    Entry<Object, Object> getResult = actualSimplifyMapToListResult.get(0);
    assertTrue(getResult instanceof ImmutableEntry);
    assertEquals("Key", getResult.key());
    assertEquals("Value", getResult.value());
  }

  /**
   * Test {@link WebUtilities#simplifyMapToList(Map)}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link WebUtilities#simplifyMapToList(Map)}
   */
  @Test
  @DisplayName("Test simplifyMapToList(Map); when HashMap(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List WebUtilities.simplifyMapToList(Map)"})
  void testSimplifyMapToList_whenHashMap_thenReturnEmpty() {
    // Arrange and Act
    List<Entry<Object, Object>> actualSimplifyMapToListResult =
        WebUtilities.simplifyMapToList(new HashMap<>());

    // Assert
    assertTrue(actualSimplifyMapToListResult.isEmpty());
  }
}
