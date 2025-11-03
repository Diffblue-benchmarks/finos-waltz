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
import org.slf4j.helpers.SubstituteLogger;
import spark.Request;
import spark.Response;

class WebUtilitiesDiffblueTest {
  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath() {
    // Arrange, Act and Assert
    assertEquals("Cannot convert empty or null segments to path/Cannot convert empty or null segments to path/",
        WebUtilities.mkPath("Cannot convert empty or null segments to path",
            "Cannot convert empty or null segments to path", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath2() {
    // Arrange, Act and Assert
    assertEquals("Predicate must be provided/Cannot convert empty or null segments to path/",
        WebUtilities.mkPath("Predicate must be provided", "Cannot convert empty or null segments to path", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath3() {
    // Arrange, Act and Assert
    assertEquals("/Cannot convert empty or null segments to path/Cannot convert empty or null segments to path",
        WebUtilities.mkPath("/", "Cannot convert empty or null segments to path",
            "Cannot convert empty or null segments to path"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath4() {
    // Arrange, Act and Assert
    assertEquals("/Cannot convert empty or null segments to path/Predicate must be provided",
        WebUtilities.mkPath("/", "Cannot convert empty or null segments to path", "Predicate must be provided"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath5() {
    // Arrange, Act and Assert
    assertEquals("Cannot convert empty or null segments to path/Predicate must be provided/",
        WebUtilities.mkPath("Cannot convert empty or null segments to path", "Predicate must be provided", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath6() {
    // Arrange, Act and Assert
    assertEquals("Cannot convert empty or null segments to path/Cannot convert empty or null segments to path/+",
        WebUtilities.mkPath("Cannot convert empty or null segments to path",
            "Cannot convert empty or null segments to path", "/+"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath7() {
    // Arrange, Act and Assert
    assertEquals("Predicate must be provided/Cannot convert empty or null segments to path/+",
        WebUtilities.mkPath("Predicate must be provided", "Cannot convert empty or null segments to path", "/+"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath8() {
    // Arrange, Act and Assert
    assertEquals("/Predicate must be provided/Cannot convert empty or null segments to path",
        WebUtilities.mkPath("/", "Predicate must be provided", "Cannot convert empty or null segments to path"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code 42/Cannot convert empty or null segments to path/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '42/Cannot convert empty or null segments to path/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturn42CannotConvertEmptyOrNullSegmentsToPath() {
    // Arrange, Act and Assert
    assertEquals("42/Cannot convert empty or null segments to path/",
        WebUtilities.mkPath("42", "Cannot convert empty or null segments to path", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code 42/Cannot convert empty or null segments to path/+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '42/Cannot convert empty or null segments to path/+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturn42CannotConvertEmptyOrNullSegmentsToPath2() {
    // Arrange, Act and Assert
    assertEquals("42/Cannot convert empty or null segments to path/+",
        WebUtilities.mkPath("42", "Cannot convert empty or null segments to path", "/+"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Array must be provided/Array must be provided/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Array must be provided/Array must be provided/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayMustBeProvidedArrayMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("Array must be provided/Array must be provided/",
        WebUtilities.mkPath("Array must be provided", "Array must be provided", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /Array must be provided/Array must be provided}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Array must be provided/Array must be provided'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayMustBeProvidedArrayMustBeProvided2() {
    // Arrange, Act and Assert
    assertEquals("/Array must be provided/Array must be provided",
        WebUtilities.mkPath("/", "Array must be provided", "Array must be provided"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Array must be provided/: Array was null/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Array must be provided/: Array was null/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayMustBeProvidedArrayWasNull() {
    // Arrange, Act and Assert
    assertEquals("Array must be provided/: Array was null/",
        WebUtilities.mkPath("Array must be provided", ": Array was null", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /Array must be provided/: Array was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Array must be provided/: Array was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayMustBeProvidedArrayWasNull2() {
    // Arrange, Act and Assert
    assertEquals("/Array must be provided/: Array was null",
        WebUtilities.mkPath("/", "Array must be provided", ": Array was null"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Array must be provided/Cannot convert empty or null segments to path/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Array must be provided/Cannot convert empty or null segments to path/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayMustBeProvidedCannotConvertEmptyOrNullSegmentsToPath() {
    // Arrange, Act and Assert
    assertEquals("Array must be provided/Cannot convert empty or null segments to path/",
        WebUtilities.mkPath("Array must be provided", "Cannot convert empty or null segments to path", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Array must be provided/Cannot convert empty or null segments to path/+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Array must be provided/Cannot convert empty or null segments to path/+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayMustBeProvidedCannotConvertEmptyOrNullSegmentsToPath2() {
    // Arrange, Act and Assert
    assertEquals("Array must be provided/Cannot convert empty or null segments to path/+",
        WebUtilities.mkPath("Array must be provided", "Cannot convert empty or null segments to path", "/+"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /Array must be provided/Cannot convert empty or null segments to path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Array must be provided/Cannot convert empty or null segments to path'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayMustBeProvidedCannotConvertEmptyOrNullSegmentsToPath3() {
    // Arrange, Act and Assert
    assertEquals("/Array must be provided/Cannot convert empty or null segments to path",
        WebUtilities.mkPath("/", "Array must be provided", "Cannot convert empty or null segments to path"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Array must be provided/Predicate must be provided/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Array must be provided/Predicate must be provided/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayMustBeProvidedPredicateMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("Array must be provided/Predicate must be provided/",
        WebUtilities.mkPath("Array must be provided", "Predicate must be provided", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /Array must be provided/Predicate must be provided}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Array must be provided/Predicate must be provided'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayMustBeProvidedPredicateMustBeProvided2() {
    // Arrange, Act and Assert
    assertEquals("/Array must be provided/Predicate must be provided",
        WebUtilities.mkPath("/", "Array must be provided", "Predicate must be provided"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Array must be provided/: Predicate was null/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Array must be provided/: Predicate was null/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayMustBeProvidedPredicateWasNull() {
    // Arrange, Act and Assert
    assertEquals("Array must be provided/: Predicate was null/",
        WebUtilities.mkPath("Array must be provided", ": Predicate was null", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /Array must be provided/: Predicate was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Array must be provided/: Predicate was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayMustBeProvidedPredicateWasNull2() {
    // Arrange, Act and Assert
    assertEquals("/Array must be provided/: Predicate was null",
        WebUtilities.mkPath("/", "Array must be provided", ": Predicate was null"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Array must be provided/yyyy-MM-dd/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Array must be provided/yyyy-MM-dd/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayMustBeProvidedYyyyMmDd() {
    // Arrange, Act and Assert
    assertEquals("Array must be provided/yyyy-MM-dd/",
        WebUtilities.mkPath("Array must be provided", "yyyy-MM-dd", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code : Array was null/Array must be provided/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return ': Array was null/Array must be provided/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayWasNullArrayMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals(": Array was null/Array must be provided/",
        WebUtilities.mkPath(": Array was null", "Array must be provided", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code : Array was null/Cannot convert empty or null segments to path/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return ': Array was null/Cannot convert empty or null segments to path/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayWasNullCannotConvertEmptyOrNullSegmentsToPath() {
    // Arrange, Act and Assert
    assertEquals(": Array was null/Cannot convert empty or null segments to path/",
        WebUtilities.mkPath(": Array was null", "Cannot convert empty or null segments to path", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code : Array was null/Cannot convert empty or null segments to path/+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return ': Array was null/Cannot convert empty or null segments to path/+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayWasNullCannotConvertEmptyOrNullSegmentsToPath2() {
    // Arrange, Act and Assert
    assertEquals(": Array was null/Cannot convert empty or null segments to path/+",
        WebUtilities.mkPath(": Array was null", "Cannot convert empty or null segments to path", "/+"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /: Array was null/Cannot convert empty or null segments to path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/: Array was null/Cannot convert empty or null segments to path'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayWasNullCannotConvertEmptyOrNullSegmentsToPath3() {
    // Arrange, Act and Assert
    assertEquals("/: Array was null/Cannot convert empty or null segments to path",
        WebUtilities.mkPath("/", ": Array was null", "Cannot convert empty or null segments to path"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code : Array was null/Predicate must be provided/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return ': Array was null/Predicate must be provided/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayWasNullPredicateMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals(": Array was null/Predicate must be provided/",
        WebUtilities.mkPath(": Array was null", "Predicate must be provided", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /: Array was null/Predicate must be provided}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/: Array was null/Predicate must be provided'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayWasNullPredicateMustBeProvided2() {
    // Arrange, Act and Assert
    assertEquals("/: Array was null/Predicate must be provided",
        WebUtilities.mkPath("/", ": Array was null", "Predicate must be provided"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code : Array was null/: Predicate was null/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return ': Array was null/: Predicate was null/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnArrayWasNullPredicateWasNull() {
    // Arrange, Act and Assert
    assertEquals(": Array was null/: Predicate was null/",
        WebUtilities.mkPath(": Array was null", ": Predicate was null", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /Cannot convert empty or null segments to path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Cannot convert empty or null segments to path'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPath() {
    // Arrange, Act and Assert
    assertEquals("/Cannot convert empty or null segments to path",
        WebUtilities.mkPath("/", "Cannot convert empty or null segments to path"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /Cannot convert empty or null segments to path/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Cannot convert empty or null segments to path/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPath2() {
    // Arrange, Act and Assert
    assertEquals("/Cannot convert empty or null segments to path/",
        WebUtilities.mkPath("/", "Cannot convert empty or null segments to path", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /+/Cannot convert empty or null segments to path/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/+/Cannot convert empty or null segments to path/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPath3() {
    // Arrange, Act and Assert
    assertEquals("/+/Cannot convert empty or null segments to path/",
        WebUtilities.mkPath("/+", "Cannot convert empty or null segments to path", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /Cannot convert empty or null segments to path/+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Cannot convert empty or null segments to path/+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPath4() {
    // Arrange, Act and Assert
    assertEquals("/Cannot convert empty or null segments to path/+",
        WebUtilities.mkPath("/", "Cannot convert empty or null segments to path", "/+"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPath5() {
    // Arrange, Act and Assert
    assertEquals("Cannot convert empty or null segments to path/",
        WebUtilities.mkPath("Cannot convert empty or null segments to path", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPath6() {
    // Arrange, Act and Assert
    assertEquals("Cannot convert empty or null segments to path/+",
        WebUtilities.mkPath("Cannot convert empty or null segments to path", "/+"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPath7() {
    // Arrange, Act and Assert
    assertEquals("Cannot convert empty or null segments to path/",
        WebUtilities.mkPath("Cannot convert empty or null segments to path", "/", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/+/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/+/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPath8() {
    // Arrange, Act and Assert
    assertEquals("Cannot convert empty or null segments to path/+/",
        WebUtilities.mkPath("Cannot convert empty or null segments to path", "/+", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /+/Cannot convert empty or null segments to path/+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/+/Cannot convert empty or null segments to path/+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPath9() {
    // Arrange, Act and Assert
    assertEquals("/+/Cannot convert empty or null segments to path/+",
        WebUtilities.mkPath("/+", "Cannot convert empty or null segments to path", "/+"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /+/Cannot convert empty or null segments to path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/+/Cannot convert empty or null segments to path'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPath10() {
    // Arrange, Act and Assert
    assertEquals("/+/Cannot convert empty or null segments to path",
        WebUtilities.mkPath("/", "/+", "Cannot convert empty or null segments to path"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /Cannot convert empty or null segments to path/42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Cannot convert empty or null segments to path/42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPath42() {
    // Arrange, Act and Assert
    assertEquals("/Cannot convert empty or null segments to path/42",
        WebUtilities.mkPath("/", "Cannot convert empty or null segments to path", "42"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/42/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/42/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPath422() {
    // Arrange, Act and Assert
    assertEquals("Cannot convert empty or null segments to path/42/",
        WebUtilities.mkPath("Cannot convert empty or null segments to path", "42", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /Cannot convert empty or null segments to path/Array must be provided}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Cannot convert empty or null segments to path/Array must be provided'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathArrayMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("/Cannot convert empty or null segments to path/Array must be provided",
        WebUtilities.mkPath("/", "Cannot convert empty or null segments to path", "Array must be provided"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/Array must be provided/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/Array must be provided/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathArrayMustBeProvided2() {
    // Arrange, Act and Assert
    assertEquals("Cannot convert empty or null segments to path/Array must be provided/",
        WebUtilities.mkPath("Cannot convert empty or null segments to path", "Array must be provided", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /Cannot convert empty or null segments to path/: Array was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Cannot convert empty or null segments to path/: Array was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathArrayWasNull() {
    // Arrange, Act and Assert
    assertEquals("/Cannot convert empty or null segments to path/: Array was null",
        WebUtilities.mkPath("/", "Cannot convert empty or null segments to path", ": Array was null"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/: Array was null/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/: Array was null/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathArrayWasNull2() {
    // Arrange, Act and Assert
    assertEquals("Cannot convert empty or null segments to path/: Array was null/",
        WebUtilities.mkPath("Cannot convert empty or null segments to path", ": Array was null", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /Cannot convert empty or null segments to path/: Predicate was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Cannot convert empty or null segments to path/: Predicate was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathPredicateWasNull() {
    // Arrange, Act and Assert
    assertEquals("/Cannot convert empty or null segments to path/: Predicate was null",
        WebUtilities.mkPath("/", "Cannot convert empty or null segments to path", ": Predicate was null"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/: Predicate was null/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/: Predicate was null/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathPredicateWasNull2() {
    // Arrange, Act and Assert
    assertEquals("Cannot convert empty or null segments to path/: Predicate was null/",
        WebUtilities.mkPath("Cannot convert empty or null segments to path", ": Predicate was null", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /Cannot convert empty or null segments to path/Segs}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Cannot convert empty or null segments to path/Segs'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathSegs() {
    // Arrange, Act and Assert
    assertEquals("/Cannot convert empty or null segments to path/Segs",
        WebUtilities.mkPath("/", "Cannot convert empty or null segments to path", "Segs"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/Segs/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/Segs/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathSegs2() {
    // Arrange, Act and Assert
    assertEquals("Cannot convert empty or null segments to path/Segs/",
        WebUtilities.mkPath("Cannot convert empty or null segments to path", "Segs", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /Cannot convert empty or null segments to path/ttf}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Cannot convert empty or null segments to path/ttf'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathTtf() {
    // Arrange, Act and Assert
    assertEquals("/Cannot convert empty or null segments to path/ttf",
        WebUtilities.mkPath("/", "Cannot convert empty or null segments to path", "ttf"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/ttf/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/ttf/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathTtf2() {
    // Arrange, Act and Assert
    assertEquals("Cannot convert empty or null segments to path/ttf/",
        WebUtilities.mkPath("Cannot convert empty or null segments to path", "ttf", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /Cannot convert empty or null segments to path/yyyy-MM-dd}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Cannot convert empty or null segments to path/yyyy-MM-dd'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathYyyyMmDd() {
    // Arrange, Act and Assert
    assertEquals("/Cannot convert empty or null segments to path/yyyy-MM-dd",
        WebUtilities.mkPath("/", "Cannot convert empty or null segments to path", "yyyy-MM-dd"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Cannot convert empty or null segments to path/yyyy-MM-dd/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Cannot convert empty or null segments to path/yyyy-MM-dd/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnCannotConvertEmptyOrNullSegmentsToPathYyyyMmDd2() {
    // Arrange, Act and Assert
    assertEquals("Cannot convert empty or null segments to path/yyyy-MM-dd/",
        WebUtilities.mkPath("Cannot convert empty or null segments to path", "yyyy-MM-dd", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Predicate must be provided/+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Predicate must be provided/+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("Predicate must be provided/+", WebUtilities.mkPath("Predicate must be provided", "/+"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Predicate must be provided/+/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Predicate must be provided/+/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvided2() {
    // Arrange, Act and Assert
    assertEquals("Predicate must be provided/+/", WebUtilities.mkPath("Predicate must be provided", "/+", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /+/Predicate must be provided/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/+/Predicate must be provided/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvided3() {
    // Arrange, Act and Assert
    assertEquals("/+/Predicate must be provided/", WebUtilities.mkPath("/+", "Predicate must be provided", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /Predicate must be provided/42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Predicate must be provided/42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvided42() {
    // Arrange, Act and Assert
    assertEquals("/Predicate must be provided/42", WebUtilities.mkPath("/", "Predicate must be provided", "42"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Predicate must be provided/Array must be provided/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Predicate must be provided/Array must be provided/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvidedArrayMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("Predicate must be provided/Array must be provided/",
        WebUtilities.mkPath("Predicate must be provided", "Array must be provided", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /Predicate must be provided/Array must be provided}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Predicate must be provided/Array must be provided'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvidedArrayMustBeProvided2() {
    // Arrange, Act and Assert
    assertEquals("/Predicate must be provided/Array must be provided",
        WebUtilities.mkPath("/", "Predicate must be provided", "Array must be provided"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Predicate must be provided/: Array was null/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Predicate must be provided/: Array was null/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvidedArrayWasNull() {
    // Arrange, Act and Assert
    assertEquals("Predicate must be provided/: Array was null/",
        WebUtilities.mkPath("Predicate must be provided", ": Array was null", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /Predicate must be provided/: Array was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Predicate must be provided/: Array was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvidedArrayWasNull2() {
    // Arrange, Act and Assert
    assertEquals("/Predicate must be provided/: Array was null",
        WebUtilities.mkPath("/", "Predicate must be provided", ": Array was null"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Predicate must be provided/Predicate must be provided/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Predicate must be provided/Predicate must be provided/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvidedPredicateMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("Predicate must be provided/Predicate must be provided/",
        WebUtilities.mkPath("Predicate must be provided", "Predicate must be provided", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /Predicate must be provided/Predicate must be provided}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Predicate must be provided/Predicate must be provided'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvidedPredicateMustBeProvided2() {
    // Arrange, Act and Assert
    assertEquals("/Predicate must be provided/Predicate must be provided",
        WebUtilities.mkPath("/", "Predicate must be provided", "Predicate must be provided"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Predicate must be provided/: Predicate was null/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Predicate must be provided/: Predicate was null/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvidedPredicateWasNull() {
    // Arrange, Act and Assert
    assertEquals("Predicate must be provided/: Predicate was null/",
        WebUtilities.mkPath("Predicate must be provided", ": Predicate was null", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /Predicate must be provided/: Predicate was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Predicate must be provided/: Predicate was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvidedPredicateWasNull2() {
    // Arrange, Act and Assert
    assertEquals("/Predicate must be provided/: Predicate was null",
        WebUtilities.mkPath("/", "Predicate must be provided", ": Predicate was null"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Predicate must be provided/Segs/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Predicate must be provided/Segs/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvidedSegs() {
    // Arrange, Act and Assert
    assertEquals("Predicate must be provided/Segs/", WebUtilities.mkPath("Predicate must be provided", "Segs", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /Predicate must be provided/Segs}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Predicate must be provided/Segs'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvidedSegs2() {
    // Arrange, Act and Assert
    assertEquals("/Predicate must be provided/Segs", WebUtilities.mkPath("/", "Predicate must be provided", "Segs"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Predicate must be provided/ttf/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Predicate must be provided/ttf/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvidedTtf() {
    // Arrange, Act and Assert
    assertEquals("Predicate must be provided/ttf/", WebUtilities.mkPath("Predicate must be provided", "ttf", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /Predicate must be provided/ttf}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Predicate must be provided/ttf'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvidedTtf2() {
    // Arrange, Act and Assert
    assertEquals("/Predicate must be provided/ttf", WebUtilities.mkPath("/", "Predicate must be provided", "ttf"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Predicate must be provided/yyyy-MM-dd/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Predicate must be provided/yyyy-MM-dd/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvidedYyyyMmDd() {
    // Arrange, Act and Assert
    assertEquals("Predicate must be provided/yyyy-MM-dd/",
        WebUtilities.mkPath("Predicate must be provided", "yyyy-MM-dd", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /Predicate must be provided/yyyy-MM-dd}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/Predicate must be provided/yyyy-MM-dd'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateMustBeProvidedYyyyMmDd2() {
    // Arrange, Act and Assert
    assertEquals("/Predicate must be provided/yyyy-MM-dd",
        WebUtilities.mkPath("/", "Predicate must be provided", "yyyy-MM-dd"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code : Predicate was null/Array must be provided/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return ': Predicate was null/Array must be provided/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateWasNullArrayMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals(": Predicate was null/Array must be provided/",
        WebUtilities.mkPath(": Predicate was null", "Array must be provided", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /: Predicate was null/Array must be provided}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/: Predicate was null/Array must be provided'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateWasNullArrayMustBeProvided2() {
    // Arrange, Act and Assert
    assertEquals("/: Predicate was null/Array must be provided",
        WebUtilities.mkPath("/", ": Predicate was null", "Array must be provided"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code : Predicate was null/: Array was null/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return ': Predicate was null/: Array was null/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateWasNullArrayWasNull() {
    // Arrange, Act and Assert
    assertEquals(": Predicate was null/: Array was null/",
        WebUtilities.mkPath(": Predicate was null", ": Array was null", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code : Predicate was null/Cannot convert empty or null segments to path/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return ': Predicate was null/Cannot convert empty or null segments to path/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateWasNullCannotConvertEmptyOrNullSegmentsToPath() {
    // Arrange, Act and Assert
    assertEquals(": Predicate was null/Cannot convert empty or null segments to path/",
        WebUtilities.mkPath(": Predicate was null", "Cannot convert empty or null segments to path", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code : Predicate was null/Cannot convert empty or null segments to path/+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return ': Predicate was null/Cannot convert empty or null segments to path/+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateWasNullCannotConvertEmptyOrNullSegmentsToPath2() {
    // Arrange, Act and Assert
    assertEquals(": Predicate was null/Cannot convert empty or null segments to path/+",
        WebUtilities.mkPath(": Predicate was null", "Cannot convert empty or null segments to path", "/+"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /: Predicate was null/Cannot convert empty or null segments to path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/: Predicate was null/Cannot convert empty or null segments to path'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateWasNullCannotConvertEmptyOrNullSegmentsToPath3() {
    // Arrange, Act and Assert
    assertEquals("/: Predicate was null/Cannot convert empty or null segments to path",
        WebUtilities.mkPath("/", ": Predicate was null", "Cannot convert empty or null segments to path"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code : Predicate was null/Predicate must be provided/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return ': Predicate was null/Predicate must be provided/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateWasNullPredicateMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals(": Predicate was null/Predicate must be provided/",
        WebUtilities.mkPath(": Predicate was null", "Predicate must be provided", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /: Predicate was null/Predicate must be provided}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/: Predicate was null/Predicate must be provided'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateWasNullPredicateMustBeProvided2() {
    // Arrange, Act and Assert
    assertEquals("/: Predicate was null/Predicate must be provided",
        WebUtilities.mkPath("/", ": Predicate was null", "Predicate must be provided"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code : Predicate was null/: Predicate was null/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return ': Predicate was null/: Predicate was null/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateWasNullPredicateWasNull() {
    // Arrange, Act and Assert
    assertEquals(": Predicate was null/: Predicate was null/",
        WebUtilities.mkPath(": Predicate was null", ": Predicate was null", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /: Predicate was null/: Predicate was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/: Predicate was null/: Predicate was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnPredicateWasNullPredicateWasNull2() {
    // Arrange, Act and Assert
    assertEquals("/: Predicate was null/: Predicate was null",
        WebUtilities.mkPath("/", ": Predicate was null", ": Predicate was null"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Segs/Cannot convert empty or null segments to path/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Segs/Cannot convert empty or null segments to path/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnSegsCannotConvertEmptyOrNullSegmentsToPath() {
    // Arrange, Act and Assert
    assertEquals("Segs/Cannot convert empty or null segments to path/",
        WebUtilities.mkPath("Segs", "Cannot convert empty or null segments to path", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Segs/Cannot convert empty or null segments to path/+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Segs/Cannot convert empty or null segments to path/+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnSegsCannotConvertEmptyOrNullSegmentsToPath2() {
    // Arrange, Act and Assert
    assertEquals("Segs/Cannot convert empty or null segments to path/+",
        WebUtilities.mkPath("Segs", "Cannot convert empty or null segments to path", "/+"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code Segs/Predicate must be provided/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'Segs/Predicate must be provided/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnSegsPredicateMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("Segs/Predicate must be provided/", WebUtilities.mkPath("Segs", "Predicate must be provided", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /+/+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/+/+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnSlashPlusSignSlashPlusSign() {
    // Arrange, Act and Assert
    assertEquals("/+/+", WebUtilities.mkPath("/+", "/+"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /+/+/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/+/+/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnSlashPlusSignSlashPlusSignSlash() {
    // Arrange, Act and Assert
    assertEquals("/+/+/", WebUtilities.mkPath("/+", "/+", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code ttf/Cannot convert empty or null segments to path/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'ttf/Cannot convert empty or null segments to path/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnTtfCannotConvertEmptyOrNullSegmentsToPath() {
    // Arrange, Act and Assert
    assertEquals("ttf/Cannot convert empty or null segments to path/",
        WebUtilities.mkPath("ttf", "Cannot convert empty or null segments to path", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code ttf/Cannot convert empty or null segments to path/+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'ttf/Cannot convert empty or null segments to path/+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnTtfCannotConvertEmptyOrNullSegmentsToPath2() {
    // Arrange, Act and Assert
    assertEquals("ttf/Cannot convert empty or null segments to path/+",
        WebUtilities.mkPath("ttf", "Cannot convert empty or null segments to path", "/+"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code ttf/Predicate must be provided/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'ttf/Predicate must be provided/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnTtfPredicateMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("ttf/Predicate must be provided/", WebUtilities.mkPath("ttf", "Predicate must be provided", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code yyyy-MM-dd/Array must be provided/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'yyyy-MM-dd/Array must be provided/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnYyyyMmDdArrayMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("yyyy-MM-dd/Array must be provided/",
        WebUtilities.mkPath("yyyy-MM-dd", "Array must be provided", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code yyyy-MM-dd/Cannot convert empty or null segments to path/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'yyyy-MM-dd/Cannot convert empty or null segments to path/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnYyyyMmDdCannotConvertEmptyOrNullSegmentsToPath() {
    // Arrange, Act and Assert
    assertEquals("yyyy-MM-dd/Cannot convert empty or null segments to path/",
        WebUtilities.mkPath("yyyy-MM-dd", "Cannot convert empty or null segments to path", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code yyyy-MM-dd/Cannot convert empty or null segments to path/+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'yyyy-MM-dd/Cannot convert empty or null segments to path/+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnYyyyMmDdCannotConvertEmptyOrNullSegmentsToPath2() {
    // Arrange, Act and Assert
    assertEquals("yyyy-MM-dd/Cannot convert empty or null segments to path/+",
        WebUtilities.mkPath("yyyy-MM-dd", "Cannot convert empty or null segments to path", "/+"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code /yyyy-MM-dd/Cannot convert empty or null segments to path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return '/yyyy-MM-dd/Cannot convert empty or null segments to path'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnYyyyMmDdCannotConvertEmptyOrNullSegmentsToPath3() {
    // Arrange, Act and Assert
    assertEquals("/yyyy-MM-dd/Cannot convert empty or null segments to path",
        WebUtilities.mkPath("/", "yyyy-MM-dd", "Cannot convert empty or null segments to path"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>Then return {@code yyyy-MM-dd/Predicate must be provided/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); then return 'yyyy-MM-dd/Predicate must be provided/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_thenReturnYyyyMmDdPredicateMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("yyyy-MM-dd/Predicate must be provided/",
        WebUtilities.mkPath("yyyy-MM-dd", "Predicate must be provided", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code 42} and {@code 42}.</li>
   *   <li>Then return {@code 42/42/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '42' and '42'; then return '42/42/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_when42And42_thenReturn4242() {
    // Arrange, Act and Assert
    assertEquals("42/42/", WebUtilities.mkPath("42", "42", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code 42} and {@code Array must be provided}.</li>
   *   <li>Then return {@code 42/Array must be provided/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '42' and 'Array must be provided'; then return '42/Array must be provided/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_when42AndArrayMustBeProvided_thenReturn42ArrayMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("42/Array must be provided/", WebUtilities.mkPath("42", "Array must be provided", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code 42} and {@code : Array was null}.</li>
   *   <li>Then return {@code 42/: Array was null/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '42' and ': Array was null'; then return '42/: Array was null/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_when42AndArrayWasNull_thenReturn42ArrayWasNull() {
    // Arrange, Act and Assert
    assertEquals("42/: Array was null/", WebUtilities.mkPath("42", ": Array was null", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code 42} and {@code Predicate must be provided}.</li>
   *   <li>Then return {@code 42/Predicate must be provided/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '42' and 'Predicate must be provided'; then return '42/Predicate must be provided/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_when42AndPredicateMustBeProvided_thenReturn42PredicateMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("42/Predicate must be provided/", WebUtilities.mkPath("42", "Predicate must be provided", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code 42} and {@code : Predicate was null}.</li>
   *   <li>Then return {@code 42/: Predicate was null/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '42' and ': Predicate was null'; then return '42/: Predicate was null/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_when42AndPredicateWasNull_thenReturn42PredicateWasNull() {
    // Arrange, Act and Assert
    assertEquals("42/: Predicate was null/", WebUtilities.mkPath("42", ": Predicate was null", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code 42} and {@code Segs}.</li>
   *   <li>Then return {@code 42/Segs/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '42' and 'Segs'; then return '42/Segs/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_when42AndSegs_thenReturn42Segs() {
    // Arrange, Act and Assert
    assertEquals("42/Segs/", WebUtilities.mkPath("42", "Segs", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code 42} and {@code /+}.</li>
   *   <li>Then return {@code 42/+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '42' and '/+'; then return '42/+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_when42AndSlashPlusSign_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42/+", WebUtilities.mkPath("42", "/+"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code 42} and {@code /+}.</li>
   *   <li>Then return {@code 42/+/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '42' and '/+'; then return '42/+/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_when42AndSlashPlusSign_thenReturn422() {
    // Arrange, Act and Assert
    assertEquals("42/+/", WebUtilities.mkPath("42", "/+", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code 42} and {@code /}.</li>
   *   <li>Then return {@code 42/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '42' and '/'; then return '42/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_when42AndSlash_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42/", WebUtilities.mkPath("42", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code 42} and {@code /}.</li>
   *   <li>Then return {@code 42/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '42' and '/'; then return '42/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_when42AndSlash_thenReturn422() {
    // Arrange, Act and Assert
    assertEquals("42/", WebUtilities.mkPath("42", "/", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code 42} and {@code ttf}.</li>
   *   <li>Then return {@code 42/ttf/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '42' and 'ttf'; then return '42/ttf/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_when42AndTtf_thenReturn42Ttf() {
    // Arrange, Act and Assert
    assertEquals("42/ttf/", WebUtilities.mkPath("42", "ttf", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code 42} and {@code yyyy-MM-dd}.</li>
   *   <li>Then return {@code 42/yyyy-MM-dd/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '42' and 'yyyy-MM-dd'; then return '42/yyyy-MM-dd/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_when42AndYyyyMmDd_thenReturn42YyyyMmDd() {
    // Arrange, Act and Assert
    assertEquals("42/yyyy-MM-dd/", WebUtilities.mkPath("42", "yyyy-MM-dd", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code Array must be provided} and {@code 42}.</li>
   *   <li>Then return {@code Array must be provided/42/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'Array must be provided' and '42'; then return 'Array must be provided/42/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenArrayMustBeProvidedAnd42_thenReturnArrayMustBeProvided42() {
    // Arrange, Act and Assert
    assertEquals("Array must be provided/42/", WebUtilities.mkPath("Array must be provided", "42", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code Array must be provided} and {@code Segs}.</li>
   *   <li>Then return {@code Array must be provided/Segs/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'Array must be provided' and 'Segs'; then return 'Array must be provided/Segs/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenArrayMustBeProvidedAndSegs_thenReturnArrayMustBeProvidedSegs() {
    // Arrange, Act and Assert
    assertEquals("Array must be provided/Segs/", WebUtilities.mkPath("Array must be provided", "Segs", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code Array must be provided} and {@code /+}.</li>
   *   <li>Then return {@code Array must be provided/+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'Array must be provided' and '/+'; then return 'Array must be provided/+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenArrayMustBeProvidedAndSlashPlusSign_thenReturnArrayMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("Array must be provided/+", WebUtilities.mkPath("Array must be provided", "/+"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code Array must be provided} and {@code /+}.</li>
   *   <li>Then return {@code Array must be provided/+/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'Array must be provided' and '/+'; then return 'Array must be provided/+/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenArrayMustBeProvidedAndSlashPlusSign_thenReturnArrayMustBeProvided2() {
    // Arrange, Act and Assert
    assertEquals("Array must be provided/+/", WebUtilities.mkPath("Array must be provided", "/+", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code Array must be provided} and {@code /}.</li>
   *   <li>Then return {@code Array must be provided/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'Array must be provided' and '/'; then return 'Array must be provided/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenArrayMustBeProvidedAndSlash_thenReturnArrayMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("Array must be provided/", WebUtilities.mkPath("Array must be provided", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code Array must be provided} and {@code /}.</li>
   *   <li>Then return {@code Array must be provided/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'Array must be provided' and '/'; then return 'Array must be provided/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenArrayMustBeProvidedAndSlash_thenReturnArrayMustBeProvided2() {
    // Arrange, Act and Assert
    assertEquals("Array must be provided/", WebUtilities.mkPath("Array must be provided", "/", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code Array must be provided} and {@code ttf}.</li>
   *   <li>Then return {@code Array must be provided/ttf/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'Array must be provided' and 'ttf'; then return 'Array must be provided/ttf/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenArrayMustBeProvidedAndTtf_thenReturnArrayMustBeProvidedTtf() {
    // Arrange, Act and Assert
    assertEquals("Array must be provided/ttf/", WebUtilities.mkPath("Array must be provided", "ttf", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code : Array was null} and {@code 42}.</li>
   *   <li>Then return {@code : Array was null/42/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when ': Array was null' and '42'; then return ': Array was null/42/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenArrayWasNullAnd42_thenReturnArrayWasNull42() {
    // Arrange, Act and Assert
    assertEquals(": Array was null/42/", WebUtilities.mkPath(": Array was null", "42", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code : Array was null} and {@code : Array was null}.</li>
   *   <li>Then return {@code : Array was null/: Array was null/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when ': Array was null' and ': Array was null'; then return ': Array was null/: Array was null/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenArrayWasNullAndArrayWasNull_thenReturnArrayWasNullArrayWasNull() {
    // Arrange, Act and Assert
    assertEquals(": Array was null/: Array was null/",
        WebUtilities.mkPath(": Array was null", ": Array was null", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code : Array was null} and {@code Segs}.</li>
   *   <li>Then return {@code : Array was null/Segs/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when ': Array was null' and 'Segs'; then return ': Array was null/Segs/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenArrayWasNullAndSegs_thenReturnArrayWasNullSegs() {
    // Arrange, Act and Assert
    assertEquals(": Array was null/Segs/", WebUtilities.mkPath(": Array was null", "Segs", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code : Array was null} and {@code /+}.</li>
   *   <li>Then return {@code : Array was null/+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when ': Array was null' and '/+'; then return ': Array was null/+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenArrayWasNullAndSlashPlusSign_thenReturnArrayWasNull() {
    // Arrange, Act and Assert
    assertEquals(": Array was null/+", WebUtilities.mkPath(": Array was null", "/+"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code : Array was null} and {@code /+}.</li>
   *   <li>Then return {@code : Array was null/+/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when ': Array was null' and '/+'; then return ': Array was null/+/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenArrayWasNullAndSlashPlusSign_thenReturnArrayWasNull2() {
    // Arrange, Act and Assert
    assertEquals(": Array was null/+/", WebUtilities.mkPath(": Array was null", "/+", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code : Array was null} and {@code /}.</li>
   *   <li>Then return {@code : Array was null/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when ': Array was null' and '/'; then return ': Array was null/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenArrayWasNullAndSlash_thenReturnArrayWasNull() {
    // Arrange, Act and Assert
    assertEquals(": Array was null/", WebUtilities.mkPath(": Array was null", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code : Array was null} and {@code /}.</li>
   *   <li>Then return {@code : Array was null/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when ': Array was null' and '/'; then return ': Array was null/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenArrayWasNullAndSlash_thenReturnArrayWasNull2() {
    // Arrange, Act and Assert
    assertEquals(": Array was null/", WebUtilities.mkPath(": Array was null", "/", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code : Array was null} and {@code ttf}.</li>
   *   <li>Then return {@code : Array was null/ttf/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when ': Array was null' and 'ttf'; then return ': Array was null/ttf/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenArrayWasNullAndTtf_thenReturnArrayWasNullTtf() {
    // Arrange, Act and Assert
    assertEquals(": Array was null/ttf/", WebUtilities.mkPath(": Array was null", "ttf", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code : Array was null} and {@code yyyy-MM-dd}.</li>
   *   <li>Then return {@code : Array was null/yyyy-MM-dd/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when ': Array was null' and 'yyyy-MM-dd'; then return ': Array was null/yyyy-MM-dd/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenArrayWasNullAndYyyyMmDd_thenReturnArrayWasNullYyyyMmDd() {
    // Arrange, Act and Assert
    assertEquals(": Array was null/yyyy-MM-dd/", WebUtilities.mkPath(": Array was null", "yyyy-MM-dd", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code Predicate must be provided} and {@code 42}.</li>
   *   <li>Then return {@code Predicate must be provided/42/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'Predicate must be provided' and '42'; then return 'Predicate must be provided/42/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenPredicateMustBeProvidedAnd42_thenReturnPredicateMustBeProvided42() {
    // Arrange, Act and Assert
    assertEquals("Predicate must be provided/42/", WebUtilities.mkPath("Predicate must be provided", "42", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code Predicate must be provided} and {@code /}.</li>
   *   <li>Then return {@code Predicate must be provided/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'Predicate must be provided' and '/'; then return 'Predicate must be provided/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenPredicateMustBeProvidedAndSlash_thenReturnPredicateMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("Predicate must be provided/", WebUtilities.mkPath("Predicate must be provided", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code Predicate must be provided} and {@code /}.</li>
   *   <li>Then return {@code Predicate must be provided/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'Predicate must be provided' and '/'; then return 'Predicate must be provided/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenPredicateMustBeProvidedAndSlash_thenReturnPredicateMustBeProvided2() {
    // Arrange, Act and Assert
    assertEquals("Predicate must be provided/", WebUtilities.mkPath("Predicate must be provided", "/", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code : Predicate was null} and {@code 42}.</li>
   *   <li>Then return {@code : Predicate was null/42/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when ': Predicate was null' and '42'; then return ': Predicate was null/42/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenPredicateWasNullAnd42_thenReturnPredicateWasNull42() {
    // Arrange, Act and Assert
    assertEquals(": Predicate was null/42/", WebUtilities.mkPath(": Predicate was null", "42", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code : Predicate was null} and {@code Segs}.</li>
   *   <li>Then return {@code : Predicate was null/Segs/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when ': Predicate was null' and 'Segs'; then return ': Predicate was null/Segs/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenPredicateWasNullAndSegs_thenReturnPredicateWasNullSegs() {
    // Arrange, Act and Assert
    assertEquals(": Predicate was null/Segs/", WebUtilities.mkPath(": Predicate was null", "Segs", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code : Predicate was null} and {@code /+}.</li>
   *   <li>Then return {@code : Predicate was null/+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when ': Predicate was null' and '/+'; then return ': Predicate was null/+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenPredicateWasNullAndSlashPlusSign_thenReturnPredicateWasNull() {
    // Arrange, Act and Assert
    assertEquals(": Predicate was null/+", WebUtilities.mkPath(": Predicate was null", "/+"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code : Predicate was null} and {@code /+}.</li>
   *   <li>Then return {@code : Predicate was null/+/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when ': Predicate was null' and '/+'; then return ': Predicate was null/+/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenPredicateWasNullAndSlashPlusSign_thenReturnPredicateWasNull2() {
    // Arrange, Act and Assert
    assertEquals(": Predicate was null/+/", WebUtilities.mkPath(": Predicate was null", "/+", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code : Predicate was null} and {@code /}.</li>
   *   <li>Then return {@code : Predicate was null/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when ': Predicate was null' and '/'; then return ': Predicate was null/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenPredicateWasNullAndSlash_thenReturnPredicateWasNull() {
    // Arrange, Act and Assert
    assertEquals(": Predicate was null/", WebUtilities.mkPath(": Predicate was null", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code : Predicate was null} and {@code /}.</li>
   *   <li>Then return {@code : Predicate was null/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when ': Predicate was null' and '/'; then return ': Predicate was null/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenPredicateWasNullAndSlash_thenReturnPredicateWasNull2() {
    // Arrange, Act and Assert
    assertEquals(": Predicate was null/", WebUtilities.mkPath(": Predicate was null", "/", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code : Predicate was null} and {@code ttf}.</li>
   *   <li>Then return {@code : Predicate was null/ttf/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when ': Predicate was null' and 'ttf'; then return ': Predicate was null/ttf/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenPredicateWasNullAndTtf_thenReturnPredicateWasNullTtf() {
    // Arrange, Act and Assert
    assertEquals(": Predicate was null/ttf/", WebUtilities.mkPath(": Predicate was null", "ttf", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code : Predicate was null} and {@code yyyy-MM-dd}.</li>
   *   <li>Then return {@code : Predicate was null/yyyy-MM-dd/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when ': Predicate was null' and 'yyyy-MM-dd'; then return ': Predicate was null/yyyy-MM-dd/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenPredicateWasNullAndYyyyMmDd_thenReturnPredicateWasNullYyyyMmDd() {
    // Arrange, Act and Assert
    assertEquals(": Predicate was null/yyyy-MM-dd/", WebUtilities.mkPath(": Predicate was null", "yyyy-MM-dd", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code Segs} and {@code 42}.</li>
   *   <li>Then return {@code Segs/42/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'Segs' and '42'; then return 'Segs/42/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSegsAnd42_thenReturnSegs42() {
    // Arrange, Act and Assert
    assertEquals("Segs/42/", WebUtilities.mkPath("Segs", "42", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code Segs} and {@code Array must be provided}.</li>
   *   <li>Then return {@code Segs/Array must be provided/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'Segs' and 'Array must be provided'; then return 'Segs/Array must be provided/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSegsAndArrayMustBeProvided_thenReturnSegsArrayMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("Segs/Array must be provided/", WebUtilities.mkPath("Segs", "Array must be provided", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code Segs} and {@code : Array was null}.</li>
   *   <li>Then return {@code Segs/: Array was null/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'Segs' and ': Array was null'; then return 'Segs/: Array was null/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSegsAndArrayWasNull_thenReturnSegsArrayWasNull() {
    // Arrange, Act and Assert
    assertEquals("Segs/: Array was null/", WebUtilities.mkPath("Segs", ": Array was null", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code Segs} and {@code : Predicate was null}.</li>
   *   <li>Then return {@code Segs/: Predicate was null/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'Segs' and ': Predicate was null'; then return 'Segs/: Predicate was null/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSegsAndPredicateWasNull_thenReturnSegsPredicateWasNull() {
    // Arrange, Act and Assert
    assertEquals("Segs/: Predicate was null/", WebUtilities.mkPath("Segs", ": Predicate was null", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code Segs} and {@code Segs}.</li>
   *   <li>Then return {@code Segs/Segs/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'Segs' and 'Segs'; then return 'Segs/Segs/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSegsAndSegs_thenReturnSegsSegs() {
    // Arrange, Act and Assert
    assertEquals("Segs/Segs/", WebUtilities.mkPath("Segs", "Segs", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code Segs} and {@code /+}.</li>
   *   <li>Then return {@code Segs/+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'Segs' and '/+'; then return 'Segs/+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSegsAndSlashPlusSign_thenReturnSegs() {
    // Arrange, Act and Assert
    assertEquals("Segs/+", WebUtilities.mkPath("Segs", "/+"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code Segs} and {@code /+}.</li>
   *   <li>Then return {@code Segs/+/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'Segs' and '/+'; then return 'Segs/+/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSegsAndSlashPlusSign_thenReturnSegs2() {
    // Arrange, Act and Assert
    assertEquals("Segs/+/", WebUtilities.mkPath("Segs", "/+", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code Segs} and {@code /}.</li>
   *   <li>Then return {@code Segs/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'Segs' and '/'; then return 'Segs/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSegsAndSlash_thenReturnSegs() {
    // Arrange, Act and Assert
    assertEquals("Segs/", WebUtilities.mkPath("Segs", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code Segs} and {@code /}.</li>
   *   <li>Then return {@code Segs/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'Segs' and '/'; then return 'Segs/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSegsAndSlash_thenReturnSegs2() {
    // Arrange, Act and Assert
    assertEquals("Segs/", WebUtilities.mkPath("Segs", "/", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code Segs} and {@code ttf}.</li>
   *   <li>Then return {@code Segs/ttf/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'Segs' and 'ttf'; then return 'Segs/ttf/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSegsAndTtf_thenReturnSegsTtf() {
    // Arrange, Act and Assert
    assertEquals("Segs/ttf/", WebUtilities.mkPath("Segs", "ttf", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code Segs} and {@code yyyy-MM-dd}.</li>
   *   <li>Then return {@code Segs/yyyy-MM-dd/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'Segs' and 'yyyy-MM-dd'; then return 'Segs/yyyy-MM-dd/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSegsAndYyyyMmDd_thenReturnSegsYyyyMmDd() {
    // Arrange, Act and Assert
    assertEquals("Segs/yyyy-MM-dd/", WebUtilities.mkPath("Segs", "yyyy-MM-dd", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code Segs}.</li>
   *   <li>Then return {@code Segs}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'Segs'; then return 'Segs'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSegs_thenReturnSegs() {
    // Arrange, Act and Assert
    assertEquals("Segs", WebUtilities.mkPath("Segs"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code 42}.</li>
   *   <li>Then return {@code /42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '42'; then return '/42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAnd42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("/42", WebUtilities.mkPath("/", "42"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code 42}.</li>
   *   <li>Then return {@code /42/Array must be provided}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '42'; then return '/42/Array must be provided'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAnd42_thenReturn42ArrayMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("/42/Array must be provided", WebUtilities.mkPath("/", "42", "Array must be provided"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code 42}.</li>
   *   <li>Then return {@code /42/: Array was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '42'; then return '/42/: Array was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAnd42_thenReturn42ArrayWasNull() {
    // Arrange, Act and Assert
    assertEquals("/42/: Array was null", WebUtilities.mkPath("/", "42", ": Array was null"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code 42}.</li>
   *   <li>Then return {@code /42/Cannot convert empty or null segments to path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '42'; then return '/42/Cannot convert empty or null segments to path'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAnd42_thenReturn42CannotConvertEmptyOrNullSegmentsToPath() {
    // Arrange, Act and Assert
    assertEquals("/42/Cannot convert empty or null segments to path",
        WebUtilities.mkPath("/", "42", "Cannot convert empty or null segments to path"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code 42}.</li>
   *   <li>Then return {@code /42/Predicate must be provided}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '42'; then return '/42/Predicate must be provided'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAnd42_thenReturn42PredicateMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("/42/Predicate must be provided", WebUtilities.mkPath("/", "42", "Predicate must be provided"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code 42}.</li>
   *   <li>Then return {@code /42/: Predicate was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '42'; then return '/42/: Predicate was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAnd42_thenReturn42PredicateWasNull() {
    // Arrange, Act and Assert
    assertEquals("/42/: Predicate was null", WebUtilities.mkPath("/", "42", ": Predicate was null"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code 42}.</li>
   *   <li>Then return {@code /42/Segs}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '42'; then return '/42/Segs'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAnd42_thenReturn42Segs() {
    // Arrange, Act and Assert
    assertEquals("/42/Segs", WebUtilities.mkPath("/", "42", "Segs"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code 42}.</li>
   *   <li>Then return {@code /42/ttf}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '42'; then return '/42/ttf'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAnd42_thenReturn42Ttf() {
    // Arrange, Act and Assert
    assertEquals("/42/ttf", WebUtilities.mkPath("/", "42", "ttf"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code 42}.</li>
   *   <li>Then return {@code /42/yyyy-MM-dd}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '42'; then return '/42/yyyy-MM-dd'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAnd42_thenReturn42YyyyMmDd() {
    // Arrange, Act and Assert
    assertEquals("/42/yyyy-MM-dd", WebUtilities.mkPath("/", "42", "yyyy-MM-dd"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code 42}.</li>
   *   <li>Then return {@code /42/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '42'; then return '/42/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAnd42_thenReturn422() {
    // Arrange, Act and Assert
    assertEquals("/42/", WebUtilities.mkPath("/", "42", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code 42}.</li>
   *   <li>Then return {@code /42/+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '42'; then return '/42/+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAnd42_thenReturn423() {
    // Arrange, Act and Assert
    assertEquals("/42/+", WebUtilities.mkPath("/", "42", "/+"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code 42}.</li>
   *   <li>Then return {@code /42/42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '42'; then return '/42/42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAnd42_thenReturn4242() {
    // Arrange, Act and Assert
    assertEquals("/42/42", WebUtilities.mkPath("/", "42", "42"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code Array must be provided}.</li>
   *   <li>Then return {@code /Array must be provided}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'Array must be provided'; then return '/Array must be provided'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayMustBeProvided_thenReturnArrayMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("/Array must be provided", WebUtilities.mkPath("/", "Array must be provided"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code Array must be provided}.</li>
   *   <li>Then return {@code /Array must be provided/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'Array must be provided'; then return '/Array must be provided/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayMustBeProvided_thenReturnArrayMustBeProvided2() {
    // Arrange, Act and Assert
    assertEquals("/Array must be provided/", WebUtilities.mkPath("/", "Array must be provided", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code Array must be provided}.</li>
   *   <li>Then return {@code /Array must be provided/+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'Array must be provided'; then return '/Array must be provided/+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayMustBeProvided_thenReturnArrayMustBeProvided3() {
    // Arrange, Act and Assert
    assertEquals("/Array must be provided/+", WebUtilities.mkPath("/", "Array must be provided", "/+"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code Array must be provided}.</li>
   *   <li>Then return {@code /Array must be provided/42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'Array must be provided'; then return '/Array must be provided/42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayMustBeProvided_thenReturnArrayMustBeProvided42() {
    // Arrange, Act and Assert
    assertEquals("/Array must be provided/42", WebUtilities.mkPath("/", "Array must be provided", "42"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code Array must be provided}.</li>
   *   <li>Then return {@code /Array must be provided/Segs}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'Array must be provided'; then return '/Array must be provided/Segs'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayMustBeProvided_thenReturnArrayMustBeProvidedSegs() {
    // Arrange, Act and Assert
    assertEquals("/Array must be provided/Segs", WebUtilities.mkPath("/", "Array must be provided", "Segs"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code Array must be provided}.</li>
   *   <li>Then return {@code /Array must be provided/ttf}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'Array must be provided'; then return '/Array must be provided/ttf'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayMustBeProvided_thenReturnArrayMustBeProvidedTtf() {
    // Arrange, Act and Assert
    assertEquals("/Array must be provided/ttf", WebUtilities.mkPath("/", "Array must be provided", "ttf"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code Array must be provided}.</li>
   *   <li>Then return {@code /Array must be provided/yyyy-MM-dd}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'Array must be provided'; then return '/Array must be provided/yyyy-MM-dd'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayMustBeProvided_thenReturnArrayMustBeProvidedYyyyMmDd() {
    // Arrange, Act and Assert
    assertEquals("/Array must be provided/yyyy-MM-dd",
        WebUtilities.mkPath("/", "Array must be provided", "yyyy-MM-dd"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code : Array was null}.</li>
   *   <li>Then return {@code /: Array was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and ': Array was null'; then return '/: Array was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayWasNull_thenReturnArrayWasNull() {
    // Arrange, Act and Assert
    assertEquals("/: Array was null", WebUtilities.mkPath("/", ": Array was null"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code : Array was null}.</li>
   *   <li>Then return {@code /: Array was null/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and ': Array was null'; then return '/: Array was null/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayWasNull_thenReturnArrayWasNull2() {
    // Arrange, Act and Assert
    assertEquals("/: Array was null/", WebUtilities.mkPath("/", ": Array was null", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code : Array was null}.</li>
   *   <li>Then return {@code /: Array was null/+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and ': Array was null'; then return '/: Array was null/+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayWasNull_thenReturnArrayWasNull3() {
    // Arrange, Act and Assert
    assertEquals("/: Array was null/+", WebUtilities.mkPath("/", ": Array was null", "/+"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code : Array was null}.</li>
   *   <li>Then return {@code /: Array was null/42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and ': Array was null'; then return '/: Array was null/42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayWasNull_thenReturnArrayWasNull42() {
    // Arrange, Act and Assert
    assertEquals("/: Array was null/42", WebUtilities.mkPath("/", ": Array was null", "42"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code : Array was null}.</li>
   *   <li>Then return {@code /: Array was null/Array must be provided}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and ': Array was null'; then return '/: Array was null/Array must be provided'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayWasNull_thenReturnArrayWasNullArrayMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("/: Array was null/Array must be provided",
        WebUtilities.mkPath("/", ": Array was null", "Array must be provided"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code : Array was null}.</li>
   *   <li>Then return {@code /: Array was null/: Array was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and ': Array was null'; then return '/: Array was null/: Array was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayWasNull_thenReturnArrayWasNullArrayWasNull() {
    // Arrange, Act and Assert
    assertEquals("/: Array was null/: Array was null",
        WebUtilities.mkPath("/", ": Array was null", ": Array was null"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code : Array was null}.</li>
   *   <li>Then return {@code /: Array was null/: Predicate was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and ': Array was null'; then return '/: Array was null/: Predicate was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayWasNull_thenReturnArrayWasNullPredicateWasNull() {
    // Arrange, Act and Assert
    assertEquals("/: Array was null/: Predicate was null",
        WebUtilities.mkPath("/", ": Array was null", ": Predicate was null"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code : Array was null}.</li>
   *   <li>Then return {@code /: Array was null/Segs}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and ': Array was null'; then return '/: Array was null/Segs'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayWasNull_thenReturnArrayWasNullSegs() {
    // Arrange, Act and Assert
    assertEquals("/: Array was null/Segs", WebUtilities.mkPath("/", ": Array was null", "Segs"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code : Array was null}.</li>
   *   <li>Then return {@code /: Array was null/ttf}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and ': Array was null'; then return '/: Array was null/ttf'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayWasNull_thenReturnArrayWasNullTtf() {
    // Arrange, Act and Assert
    assertEquals("/: Array was null/ttf", WebUtilities.mkPath("/", ": Array was null", "ttf"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code : Array was null}.</li>
   *   <li>Then return {@code /: Array was null/yyyy-MM-dd}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and ': Array was null'; then return '/: Array was null/yyyy-MM-dd'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndArrayWasNull_thenReturnArrayWasNullYyyyMmDd() {
    // Arrange, Act and Assert
    assertEquals("/: Array was null/yyyy-MM-dd", WebUtilities.mkPath("/", ": Array was null", "yyyy-MM-dd"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code Predicate must be provided}.</li>
   *   <li>Then return {@code /Predicate must be provided}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'Predicate must be provided'; then return '/Predicate must be provided'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndPredicateMustBeProvided_thenReturnPredicateMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("/Predicate must be provided", WebUtilities.mkPath("/", "Predicate must be provided"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code Predicate must be provided}.</li>
   *   <li>Then return {@code /Predicate must be provided/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'Predicate must be provided'; then return '/Predicate must be provided/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndPredicateMustBeProvided_thenReturnPredicateMustBeProvided2() {
    // Arrange, Act and Assert
    assertEquals("/Predicate must be provided/", WebUtilities.mkPath("/", "Predicate must be provided", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code Predicate must be provided}.</li>
   *   <li>Then return {@code /Predicate must be provided/+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'Predicate must be provided'; then return '/Predicate must be provided/+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndPredicateMustBeProvided_thenReturnPredicateMustBeProvided3() {
    // Arrange, Act and Assert
    assertEquals("/Predicate must be provided/+", WebUtilities.mkPath("/", "Predicate must be provided", "/+"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code : Predicate was null}.</li>
   *   <li>Then return {@code /: Predicate was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and ': Predicate was null'; then return '/: Predicate was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndPredicateWasNull_thenReturnPredicateWasNull() {
    // Arrange, Act and Assert
    assertEquals("/: Predicate was null", WebUtilities.mkPath("/", ": Predicate was null"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code : Predicate was null}.</li>
   *   <li>Then return {@code /: Predicate was null/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and ': Predicate was null'; then return '/: Predicate was null/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndPredicateWasNull_thenReturnPredicateWasNull2() {
    // Arrange, Act and Assert
    assertEquals("/: Predicate was null/", WebUtilities.mkPath("/", ": Predicate was null", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code : Predicate was null}.</li>
   *   <li>Then return {@code /: Predicate was null/+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and ': Predicate was null'; then return '/: Predicate was null/+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndPredicateWasNull_thenReturnPredicateWasNull3() {
    // Arrange, Act and Assert
    assertEquals("/: Predicate was null/+", WebUtilities.mkPath("/", ": Predicate was null", "/+"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code : Predicate was null}.</li>
   *   <li>Then return {@code /: Predicate was null/42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and ': Predicate was null'; then return '/: Predicate was null/42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndPredicateWasNull_thenReturnPredicateWasNull42() {
    // Arrange, Act and Assert
    assertEquals("/: Predicate was null/42", WebUtilities.mkPath("/", ": Predicate was null", "42"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code : Predicate was null}.</li>
   *   <li>Then return {@code /: Predicate was null/: Array was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and ': Predicate was null'; then return '/: Predicate was null/: Array was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndPredicateWasNull_thenReturnPredicateWasNullArrayWasNull() {
    // Arrange, Act and Assert
    assertEquals("/: Predicate was null/: Array was null",
        WebUtilities.mkPath("/", ": Predicate was null", ": Array was null"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code : Predicate was null}.</li>
   *   <li>Then return {@code /: Predicate was null/Segs}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and ': Predicate was null'; then return '/: Predicate was null/Segs'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndPredicateWasNull_thenReturnPredicateWasNullSegs() {
    // Arrange, Act and Assert
    assertEquals("/: Predicate was null/Segs", WebUtilities.mkPath("/", ": Predicate was null", "Segs"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code : Predicate was null}.</li>
   *   <li>Then return {@code /: Predicate was null/ttf}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and ': Predicate was null'; then return '/: Predicate was null/ttf'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndPredicateWasNull_thenReturnPredicateWasNullTtf() {
    // Arrange, Act and Assert
    assertEquals("/: Predicate was null/ttf", WebUtilities.mkPath("/", ": Predicate was null", "ttf"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code : Predicate was null}.</li>
   *   <li>Then return {@code /: Predicate was null/yyyy-MM-dd}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and ': Predicate was null'; then return '/: Predicate was null/yyyy-MM-dd'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndPredicateWasNull_thenReturnPredicateWasNullYyyyMmDd() {
    // Arrange, Act and Assert
    assertEquals("/: Predicate was null/yyyy-MM-dd", WebUtilities.mkPath("/", ": Predicate was null", "yyyy-MM-dd"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code Segs}.</li>
   *   <li>Then return {@code /Segs}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'Segs'; then return '/Segs'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSegs_thenReturnSegs() {
    // Arrange, Act and Assert
    assertEquals("/Segs", WebUtilities.mkPath("/", "Segs"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code Segs}.</li>
   *   <li>Then return {@code /Segs/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'Segs'; then return '/Segs/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSegs_thenReturnSegs2() {
    // Arrange, Act and Assert
    assertEquals("/Segs/", WebUtilities.mkPath("/", "Segs", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code Segs}.</li>
   *   <li>Then return {@code /Segs/+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'Segs'; then return '/Segs/+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSegs_thenReturnSegs3() {
    // Arrange, Act and Assert
    assertEquals("/Segs/+", WebUtilities.mkPath("/", "Segs", "/+"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code Segs}.</li>
   *   <li>Then return {@code /Segs/42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'Segs'; then return '/Segs/42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSegs_thenReturnSegs42() {
    // Arrange, Act and Assert
    assertEquals("/Segs/42", WebUtilities.mkPath("/", "Segs", "42"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code Segs}.</li>
   *   <li>Then return {@code /Segs/Array must be provided}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'Segs'; then return '/Segs/Array must be provided'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSegs_thenReturnSegsArrayMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("/Segs/Array must be provided", WebUtilities.mkPath("/", "Segs", "Array must be provided"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code Segs}.</li>
   *   <li>Then return {@code /Segs/: Array was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'Segs'; then return '/Segs/: Array was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSegs_thenReturnSegsArrayWasNull() {
    // Arrange, Act and Assert
    assertEquals("/Segs/: Array was null", WebUtilities.mkPath("/", "Segs", ": Array was null"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code Segs}.</li>
   *   <li>Then return {@code /Segs/Cannot convert empty or null segments to path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'Segs'; then return '/Segs/Cannot convert empty or null segments to path'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSegs_thenReturnSegsCannotConvertEmptyOrNullSegmentsToPath() {
    // Arrange, Act and Assert
    assertEquals("/Segs/Cannot convert empty or null segments to path",
        WebUtilities.mkPath("/", "Segs", "Cannot convert empty or null segments to path"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code Segs}.</li>
   *   <li>Then return {@code /Segs/Predicate must be provided}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'Segs'; then return '/Segs/Predicate must be provided'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSegs_thenReturnSegsPredicateMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("/Segs/Predicate must be provided", WebUtilities.mkPath("/", "Segs", "Predicate must be provided"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code Segs}.</li>
   *   <li>Then return {@code /Segs/: Predicate was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'Segs'; then return '/Segs/: Predicate was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSegs_thenReturnSegsPredicateWasNull() {
    // Arrange, Act and Assert
    assertEquals("/Segs/: Predicate was null", WebUtilities.mkPath("/", "Segs", ": Predicate was null"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code Segs}.</li>
   *   <li>Then return {@code /Segs/Segs}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'Segs'; then return '/Segs/Segs'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSegs_thenReturnSegsSegs() {
    // Arrange, Act and Assert
    assertEquals("/Segs/Segs", WebUtilities.mkPath("/", "Segs", "Segs"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code Segs}.</li>
   *   <li>Then return {@code /Segs/ttf}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'Segs'; then return '/Segs/ttf'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSegs_thenReturnSegsTtf() {
    // Arrange, Act and Assert
    assertEquals("/Segs/ttf", WebUtilities.mkPath("/", "Segs", "ttf"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code Segs}.</li>
   *   <li>Then return {@code /Segs/yyyy-MM-dd}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'Segs'; then return '/Segs/yyyy-MM-dd'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSegs_thenReturnSegsYyyyMmDd() {
    // Arrange, Act and Assert
    assertEquals("/Segs/yyyy-MM-dd", WebUtilities.mkPath("/", "Segs", "yyyy-MM-dd"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code /+}.</li>
   *   <li>Then return {@code /+/42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/+'; then return '/+/42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlashPlusSign_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("/+/42", WebUtilities.mkPath("/", "/+", "42"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code /+}.</li>
   *   <li>Then return {@code /+/Array must be provided}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/+'; then return '/+/Array must be provided'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlashPlusSign_thenReturnArrayMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("/+/Array must be provided", WebUtilities.mkPath("/", "/+", "Array must be provided"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code /+}.</li>
   *   <li>Then return {@code /+/: Array was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/+'; then return '/+/: Array was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlashPlusSign_thenReturnArrayWasNull() {
    // Arrange, Act and Assert
    assertEquals("/+/: Array was null", WebUtilities.mkPath("/", "/+", ": Array was null"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code /+}.</li>
   *   <li>Then return {@code /+/Predicate must be provided}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/+'; then return '/+/Predicate must be provided'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlashPlusSign_thenReturnPredicateMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("/+/Predicate must be provided", WebUtilities.mkPath("/", "/+", "Predicate must be provided"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code /+}.</li>
   *   <li>Then return {@code /+/: Predicate was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/+'; then return '/+/: Predicate was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlashPlusSign_thenReturnPredicateWasNull() {
    // Arrange, Act and Assert
    assertEquals("/+/: Predicate was null", WebUtilities.mkPath("/", "/+", ": Predicate was null"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code /+}.</li>
   *   <li>Then return {@code /+/Segs}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/+'; then return '/+/Segs'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlashPlusSign_thenReturnSegs() {
    // Arrange, Act and Assert
    assertEquals("/+/Segs", WebUtilities.mkPath("/", "/+", "Segs"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code /+}.</li>
   *   <li>Then return {@code /+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/+'; then return '/+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlashPlusSign_thenReturnSlashPlusSign() {
    // Arrange, Act and Assert
    assertEquals("/+", WebUtilities.mkPath("/", "/+"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code /+}.</li>
   *   <li>Then return {@code /+/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/+'; then return '/+/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlashPlusSign_thenReturnSlashPlusSignSlash() {
    // Arrange, Act and Assert
    assertEquals("/+/", WebUtilities.mkPath("/", "/+", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code /+}.</li>
   *   <li>Then return {@code /+/+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/+'; then return '/+/+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlashPlusSign_thenReturnSlashPlusSignSlashPlusSign() {
    // Arrange, Act and Assert
    assertEquals("/+/+", WebUtilities.mkPath("/", "/+", "/+"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code /+}.</li>
   *   <li>Then return {@code /+/ttf}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/+'; then return '/+/ttf'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlashPlusSign_thenReturnTtf() {
    // Arrange, Act and Assert
    assertEquals("/+/ttf", WebUtilities.mkPath("/", "/+", "ttf"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code /+}.</li>
   *   <li>Then return {@code /+/yyyy-MM-dd}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/+'; then return '/+/yyyy-MM-dd'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlashPlusSign_thenReturnYyyyMmDd() {
    // Arrange, Act and Assert
    assertEquals("/+/yyyy-MM-dd", WebUtilities.mkPath("/", "/+", "yyyy-MM-dd"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code /}.</li>
   *   <li>Then return {@code /42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/'; then return '/42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlash_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("/42", WebUtilities.mkPath("/", "/", "42"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code /}.</li>
   *   <li>Then return {@code /Array must be provided}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/'; then return '/Array must be provided'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlash_thenReturnArrayMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("/Array must be provided", WebUtilities.mkPath("/", "/", "Array must be provided"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code /}.</li>
   *   <li>Then return {@code /: Array was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/'; then return '/: Array was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlash_thenReturnArrayWasNull() {
    // Arrange, Act and Assert
    assertEquals("/: Array was null", WebUtilities.mkPath("/", "/", ": Array was null"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code /}.</li>
   *   <li>Then return {@code /Cannot convert empty or null segments to path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/'; then return '/Cannot convert empty or null segments to path'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlash_thenReturnCannotConvertEmptyOrNullSegmentsToPath() {
    // Arrange, Act and Assert
    assertEquals("/Cannot convert empty or null segments to path",
        WebUtilities.mkPath("/", "/", "Cannot convert empty or null segments to path"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code /}.</li>
   *   <li>Then return {@code /Predicate must be provided}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/'; then return '/Predicate must be provided'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlash_thenReturnPredicateMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("/Predicate must be provided", WebUtilities.mkPath("/", "/", "Predicate must be provided"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code /}.</li>
   *   <li>Then return {@code /: Predicate was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/'; then return '/: Predicate was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlash_thenReturnPredicateWasNull() {
    // Arrange, Act and Assert
    assertEquals("/: Predicate was null", WebUtilities.mkPath("/", "/", ": Predicate was null"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code /}.</li>
   *   <li>Then return {@code /Segs}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/'; then return '/Segs'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlash_thenReturnSegs() {
    // Arrange, Act and Assert
    assertEquals("/Segs", WebUtilities.mkPath("/", "/", "Segs"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code /}.</li>
   *   <li>Then return {@code /}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/'; then return '/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlash_thenReturnSlash() {
    // Arrange, Act and Assert
    assertEquals("/", WebUtilities.mkPath("/", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code /}.</li>
   *   <li>Then return {@code /}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/'; then return '/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlash_thenReturnSlash2() {
    // Arrange, Act and Assert
    assertEquals("/", WebUtilities.mkPath("/", "/", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code /}.</li>
   *   <li>Then return {@code /+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/'; then return '/+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlash_thenReturnSlashPlusSign() {
    // Arrange, Act and Assert
    assertEquals("/+", WebUtilities.mkPath("/", "/", "/+"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code /}.</li>
   *   <li>Then return {@code /ttf}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/'; then return '/ttf'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlash_thenReturnTtf() {
    // Arrange, Act and Assert
    assertEquals("/ttf", WebUtilities.mkPath("/", "/", "ttf"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code /}.</li>
   *   <li>Then return {@code /yyyy-MM-dd}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and '/'; then return '/yyyy-MM-dd'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndSlash_thenReturnYyyyMmDd() {
    // Arrange, Act and Assert
    assertEquals("/yyyy-MM-dd", WebUtilities.mkPath("/", "/", "yyyy-MM-dd"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code ttf}.</li>
   *   <li>Then return {@code /ttf}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'ttf'; then return '/ttf'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndTtf_thenReturnTtf() {
    // Arrange, Act and Assert
    assertEquals("/ttf", WebUtilities.mkPath("/", "ttf"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code ttf}.</li>
   *   <li>Then return {@code /ttf/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'ttf'; then return '/ttf/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndTtf_thenReturnTtf2() {
    // Arrange, Act and Assert
    assertEquals("/ttf/", WebUtilities.mkPath("/", "ttf", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code ttf}.</li>
   *   <li>Then return {@code /ttf/+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'ttf'; then return '/ttf/+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndTtf_thenReturnTtf3() {
    // Arrange, Act and Assert
    assertEquals("/ttf/+", WebUtilities.mkPath("/", "ttf", "/+"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code ttf}.</li>
   *   <li>Then return {@code /ttf/42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'ttf'; then return '/ttf/42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndTtf_thenReturnTtf42() {
    // Arrange, Act and Assert
    assertEquals("/ttf/42", WebUtilities.mkPath("/", "ttf", "42"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code ttf}.</li>
   *   <li>Then return {@code /ttf/Array must be provided}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'ttf'; then return '/ttf/Array must be provided'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndTtf_thenReturnTtfArrayMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("/ttf/Array must be provided", WebUtilities.mkPath("/", "ttf", "Array must be provided"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code ttf}.</li>
   *   <li>Then return {@code /ttf/: Array was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'ttf'; then return '/ttf/: Array was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndTtf_thenReturnTtfArrayWasNull() {
    // Arrange, Act and Assert
    assertEquals("/ttf/: Array was null", WebUtilities.mkPath("/", "ttf", ": Array was null"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code ttf}.</li>
   *   <li>Then return {@code /ttf/Cannot convert empty or null segments to path}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'ttf'; then return '/ttf/Cannot convert empty or null segments to path'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndTtf_thenReturnTtfCannotConvertEmptyOrNullSegmentsToPath() {
    // Arrange, Act and Assert
    assertEquals("/ttf/Cannot convert empty or null segments to path",
        WebUtilities.mkPath("/", "ttf", "Cannot convert empty or null segments to path"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code ttf}.</li>
   *   <li>Then return {@code /ttf/Predicate must be provided}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'ttf'; then return '/ttf/Predicate must be provided'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndTtf_thenReturnTtfPredicateMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("/ttf/Predicate must be provided", WebUtilities.mkPath("/", "ttf", "Predicate must be provided"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code ttf}.</li>
   *   <li>Then return {@code /ttf/: Predicate was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'ttf'; then return '/ttf/: Predicate was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndTtf_thenReturnTtfPredicateWasNull() {
    // Arrange, Act and Assert
    assertEquals("/ttf/: Predicate was null", WebUtilities.mkPath("/", "ttf", ": Predicate was null"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code ttf}.</li>
   *   <li>Then return {@code /ttf/Segs}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'ttf'; then return '/ttf/Segs'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndTtf_thenReturnTtfSegs() {
    // Arrange, Act and Assert
    assertEquals("/ttf/Segs", WebUtilities.mkPath("/", "ttf", "Segs"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code ttf}.</li>
   *   <li>Then return {@code /ttf/ttf}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'ttf'; then return '/ttf/ttf'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndTtf_thenReturnTtfTtf() {
    // Arrange, Act and Assert
    assertEquals("/ttf/ttf", WebUtilities.mkPath("/", "ttf", "ttf"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code ttf}.</li>
   *   <li>Then return {@code /ttf/yyyy-MM-dd}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'ttf'; then return '/ttf/yyyy-MM-dd'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndTtf_thenReturnTtfYyyyMmDd() {
    // Arrange, Act and Assert
    assertEquals("/ttf/yyyy-MM-dd", WebUtilities.mkPath("/", "ttf", "yyyy-MM-dd"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code yyyy-MM-dd}.</li>
   *   <li>Then return {@code /yyyy-MM-dd}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'yyyy-MM-dd'; then return '/yyyy-MM-dd'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndYyyyMmDd_thenReturnYyyyMmDd() {
    // Arrange, Act and Assert
    assertEquals("/yyyy-MM-dd", WebUtilities.mkPath("/", "yyyy-MM-dd"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code yyyy-MM-dd}.</li>
   *   <li>Then return {@code /yyyy-MM-dd/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'yyyy-MM-dd'; then return '/yyyy-MM-dd/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndYyyyMmDd_thenReturnYyyyMmDd2() {
    // Arrange, Act and Assert
    assertEquals("/yyyy-MM-dd/", WebUtilities.mkPath("/", "yyyy-MM-dd", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code yyyy-MM-dd}.</li>
   *   <li>Then return {@code /yyyy-MM-dd/+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'yyyy-MM-dd'; then return '/yyyy-MM-dd/+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndYyyyMmDd_thenReturnYyyyMmDd3() {
    // Arrange, Act and Assert
    assertEquals("/yyyy-MM-dd/+", WebUtilities.mkPath("/", "yyyy-MM-dd", "/+"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code yyyy-MM-dd}.</li>
   *   <li>Then return {@code /yyyy-MM-dd/42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'yyyy-MM-dd'; then return '/yyyy-MM-dd/42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndYyyyMmDd_thenReturnYyyyMmDd42() {
    // Arrange, Act and Assert
    assertEquals("/yyyy-MM-dd/42", WebUtilities.mkPath("/", "yyyy-MM-dd", "42"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code yyyy-MM-dd}.</li>
   *   <li>Then return {@code /yyyy-MM-dd/Array must be provided}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'yyyy-MM-dd'; then return '/yyyy-MM-dd/Array must be provided'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndYyyyMmDd_thenReturnYyyyMmDdArrayMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("/yyyy-MM-dd/Array must be provided",
        WebUtilities.mkPath("/", "yyyy-MM-dd", "Array must be provided"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code yyyy-MM-dd}.</li>
   *   <li>Then return {@code /yyyy-MM-dd/: Array was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'yyyy-MM-dd'; then return '/yyyy-MM-dd/: Array was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndYyyyMmDd_thenReturnYyyyMmDdArrayWasNull() {
    // Arrange, Act and Assert
    assertEquals("/yyyy-MM-dd/: Array was null", WebUtilities.mkPath("/", "yyyy-MM-dd", ": Array was null"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code yyyy-MM-dd}.</li>
   *   <li>Then return {@code /yyyy-MM-dd/Predicate must be provided}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'yyyy-MM-dd'; then return '/yyyy-MM-dd/Predicate must be provided'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndYyyyMmDd_thenReturnYyyyMmDdPredicateMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("/yyyy-MM-dd/Predicate must be provided",
        WebUtilities.mkPath("/", "yyyy-MM-dd", "Predicate must be provided"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code yyyy-MM-dd}.</li>
   *   <li>Then return {@code /yyyy-MM-dd/: Predicate was null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'yyyy-MM-dd'; then return '/yyyy-MM-dd/: Predicate was null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndYyyyMmDd_thenReturnYyyyMmDdPredicateWasNull() {
    // Arrange, Act and Assert
    assertEquals("/yyyy-MM-dd/: Predicate was null", WebUtilities.mkPath("/", "yyyy-MM-dd", ": Predicate was null"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code yyyy-MM-dd}.</li>
   *   <li>Then return {@code /yyyy-MM-dd/Segs}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'yyyy-MM-dd'; then return '/yyyy-MM-dd/Segs'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndYyyyMmDd_thenReturnYyyyMmDdSegs() {
    // Arrange, Act and Assert
    assertEquals("/yyyy-MM-dd/Segs", WebUtilities.mkPath("/", "yyyy-MM-dd", "Segs"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code yyyy-MM-dd}.</li>
   *   <li>Then return {@code /yyyy-MM-dd/ttf}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'yyyy-MM-dd'; then return '/yyyy-MM-dd/ttf'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndYyyyMmDd_thenReturnYyyyMmDdTtf() {
    // Arrange, Act and Assert
    assertEquals("/yyyy-MM-dd/ttf", WebUtilities.mkPath("/", "yyyy-MM-dd", "ttf"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /} and {@code yyyy-MM-dd}.</li>
   *   <li>Then return {@code /yyyy-MM-dd/yyyy-MM-dd}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/' and 'yyyy-MM-dd'; then return '/yyyy-MM-dd/yyyy-MM-dd'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashAndYyyyMmDd_thenReturnYyyyMmDdYyyyMmDd() {
    // Arrange, Act and Assert
    assertEquals("/yyyy-MM-dd/yyyy-MM-dd", WebUtilities.mkPath("/", "yyyy-MM-dd", "yyyy-MM-dd"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /+} and {@code 42}.</li>
   *   <li>Then return {@code /+/42/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/+' and '42'; then return '/+/42/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashPlusSignAnd42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("/+/42/", WebUtilities.mkPath("/+", "42", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /+} and {@code Array must be provided}.</li>
   *   <li>Then return {@code /+/Array must be provided/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/+' and 'Array must be provided'; then return '/+/Array must be provided/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashPlusSignAndArrayMustBeProvided_thenReturnArrayMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("/+/Array must be provided/", WebUtilities.mkPath("/+", "Array must be provided", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /+} and {@code : Array was null}.</li>
   *   <li>Then return {@code /+/: Array was null/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/+' and ': Array was null'; then return '/+/: Array was null/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashPlusSignAndArrayWasNull_thenReturnArrayWasNull() {
    // Arrange, Act and Assert
    assertEquals("/+/: Array was null/", WebUtilities.mkPath("/+", ": Array was null", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /+} and {@code : Predicate was null}.</li>
   *   <li>Then return {@code /+/: Predicate was null/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/+' and ': Predicate was null'; then return '/+/: Predicate was null/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashPlusSignAndPredicateWasNull_thenReturnPredicateWasNull() {
    // Arrange, Act and Assert
    assertEquals("/+/: Predicate was null/", WebUtilities.mkPath("/+", ": Predicate was null", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /+} and {@code Segs}.</li>
   *   <li>Then return {@code /+/Segs/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/+' and 'Segs'; then return '/+/Segs/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashPlusSignAndSegs_thenReturnSegs() {
    // Arrange, Act and Assert
    assertEquals("/+/Segs/", WebUtilities.mkPath("/+", "Segs", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /+} and {@code /}.</li>
   *   <li>Then return {@code /+/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/+' and '/'; then return '/+/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashPlusSignAndSlash_thenReturnSlashPlusSignSlash() {
    // Arrange, Act and Assert
    assertEquals("/+/", WebUtilities.mkPath("/+", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /+} and {@code /}.</li>
   *   <li>Then return {@code /+/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/+' and '/'; then return '/+/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashPlusSignAndSlash_thenReturnSlashPlusSignSlash2() {
    // Arrange, Act and Assert
    assertEquals("/+/", WebUtilities.mkPath("/+", "/", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /+} and {@code ttf}.</li>
   *   <li>Then return {@code /+/ttf/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/+' and 'ttf'; then return '/+/ttf/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashPlusSignAndTtf_thenReturnTtf() {
    // Arrange, Act and Assert
    assertEquals("/+/ttf/", WebUtilities.mkPath("/+", "ttf", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code /+} and {@code yyyy-MM-dd}.</li>
   *   <li>Then return {@code /+/yyyy-MM-dd/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when '/+' and 'yyyy-MM-dd'; then return '/+/yyyy-MM-dd/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenSlashPlusSignAndYyyyMmDd_thenReturnYyyyMmDd() {
    // Arrange, Act and Assert
    assertEquals("/+/yyyy-MM-dd/", WebUtilities.mkPath("/+", "yyyy-MM-dd", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code ttf} and {@code 42}.</li>
   *   <li>Then return {@code ttf/42/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'ttf' and '42'; then return 'ttf/42/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenTtfAnd42_thenReturnTtf42() {
    // Arrange, Act and Assert
    assertEquals("ttf/42/", WebUtilities.mkPath("ttf", "42", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code ttf} and {@code Array must be provided}.</li>
   *   <li>Then return {@code ttf/Array must be provided/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'ttf' and 'Array must be provided'; then return 'ttf/Array must be provided/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenTtfAndArrayMustBeProvided_thenReturnTtfArrayMustBeProvided() {
    // Arrange, Act and Assert
    assertEquals("ttf/Array must be provided/", WebUtilities.mkPath("ttf", "Array must be provided", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code ttf} and {@code : Array was null}.</li>
   *   <li>Then return {@code ttf/: Array was null/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'ttf' and ': Array was null'; then return 'ttf/: Array was null/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenTtfAndArrayWasNull_thenReturnTtfArrayWasNull() {
    // Arrange, Act and Assert
    assertEquals("ttf/: Array was null/", WebUtilities.mkPath("ttf", ": Array was null", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code ttf} and {@code : Predicate was null}.</li>
   *   <li>Then return {@code ttf/: Predicate was null/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'ttf' and ': Predicate was null'; then return 'ttf/: Predicate was null/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenTtfAndPredicateWasNull_thenReturnTtfPredicateWasNull() {
    // Arrange, Act and Assert
    assertEquals("ttf/: Predicate was null/", WebUtilities.mkPath("ttf", ": Predicate was null", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code ttf} and {@code Segs}.</li>
   *   <li>Then return {@code ttf/Segs/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'ttf' and 'Segs'; then return 'ttf/Segs/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenTtfAndSegs_thenReturnTtfSegs() {
    // Arrange, Act and Assert
    assertEquals("ttf/Segs/", WebUtilities.mkPath("ttf", "Segs", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code ttf} and {@code /+}.</li>
   *   <li>Then return {@code ttf/+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'ttf' and '/+'; then return 'ttf/+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenTtfAndSlashPlusSign_thenReturnTtf() {
    // Arrange, Act and Assert
    assertEquals("ttf/+", WebUtilities.mkPath("ttf", "/+"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code ttf} and {@code /+}.</li>
   *   <li>Then return {@code ttf/+/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'ttf' and '/+'; then return 'ttf/+/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenTtfAndSlashPlusSign_thenReturnTtf2() {
    // Arrange, Act and Assert
    assertEquals("ttf/+/", WebUtilities.mkPath("ttf", "/+", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code ttf} and {@code /}.</li>
   *   <li>Then return {@code ttf/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'ttf' and '/'; then return 'ttf/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenTtfAndSlash_thenReturnTtf() {
    // Arrange, Act and Assert
    assertEquals("ttf/", WebUtilities.mkPath("ttf", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code ttf} and {@code /}.</li>
   *   <li>Then return {@code ttf/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'ttf' and '/'; then return 'ttf/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenTtfAndSlash_thenReturnTtf2() {
    // Arrange, Act and Assert
    assertEquals("ttf/", WebUtilities.mkPath("ttf", "/", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code ttf} and {@code ttf}.</li>
   *   <li>Then return {@code ttf/ttf/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'ttf' and 'ttf'; then return 'ttf/ttf/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenTtfAndTtf_thenReturnTtfTtf() {
    // Arrange, Act and Assert
    assertEquals("ttf/ttf/", WebUtilities.mkPath("ttf", "ttf", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code ttf} and {@code yyyy-MM-dd}.</li>
   *   <li>Then return {@code ttf/yyyy-MM-dd/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'ttf' and 'yyyy-MM-dd'; then return 'ttf/yyyy-MM-dd/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenTtfAndYyyyMmDd_thenReturnTtfYyyyMmDd() {
    // Arrange, Act and Assert
    assertEquals("ttf/yyyy-MM-dd/", WebUtilities.mkPath("ttf", "yyyy-MM-dd", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd} and {@code 42}.</li>
   *   <li>Then return {@code yyyy-MM-dd/42/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'yyyy-MM-dd' and '42'; then return 'yyyy-MM-dd/42/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenYyyyMmDdAnd42_thenReturnYyyyMmDd42() {
    // Arrange, Act and Assert
    assertEquals("yyyy-MM-dd/42/", WebUtilities.mkPath("yyyy-MM-dd", "42", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd} and {@code : Array was null}.</li>
   *   <li>Then return {@code yyyy-MM-dd/: Array was null/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'yyyy-MM-dd' and ': Array was null'; then return 'yyyy-MM-dd/: Array was null/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenYyyyMmDdAndArrayWasNull_thenReturnYyyyMmDdArrayWasNull() {
    // Arrange, Act and Assert
    assertEquals("yyyy-MM-dd/: Array was null/", WebUtilities.mkPath("yyyy-MM-dd", ": Array was null", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd} and {@code : Predicate was null}.</li>
   *   <li>Then return {@code yyyy-MM-dd/: Predicate was null/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'yyyy-MM-dd' and ': Predicate was null'; then return 'yyyy-MM-dd/: Predicate was null/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenYyyyMmDdAndPredicateWasNull_thenReturnYyyyMmDdPredicateWasNull() {
    // Arrange, Act and Assert
    assertEquals("yyyy-MM-dd/: Predicate was null/", WebUtilities.mkPath("yyyy-MM-dd", ": Predicate was null", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd} and {@code Segs}.</li>
   *   <li>Then return {@code yyyy-MM-dd/Segs/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'yyyy-MM-dd' and 'Segs'; then return 'yyyy-MM-dd/Segs/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenYyyyMmDdAndSegs_thenReturnYyyyMmDdSegs() {
    // Arrange, Act and Assert
    assertEquals("yyyy-MM-dd/Segs/", WebUtilities.mkPath("yyyy-MM-dd", "Segs", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd} and {@code /+}.</li>
   *   <li>Then return {@code yyyy-MM-dd/+}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'yyyy-MM-dd' and '/+'; then return 'yyyy-MM-dd/+'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenYyyyMmDdAndSlashPlusSign_thenReturnYyyyMmDd() {
    // Arrange, Act and Assert
    assertEquals("yyyy-MM-dd/+", WebUtilities.mkPath("yyyy-MM-dd", "/+"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd} and {@code /+}.</li>
   *   <li>Then return {@code yyyy-MM-dd/+/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'yyyy-MM-dd' and '/+'; then return 'yyyy-MM-dd/+/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenYyyyMmDdAndSlashPlusSign_thenReturnYyyyMmDd2() {
    // Arrange, Act and Assert
    assertEquals("yyyy-MM-dd/+/", WebUtilities.mkPath("yyyy-MM-dd", "/+", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd} and {@code /}.</li>
   *   <li>Then return {@code yyyy-MM-dd/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'yyyy-MM-dd' and '/'; then return 'yyyy-MM-dd/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenYyyyMmDdAndSlash_thenReturnYyyyMmDd() {
    // Arrange, Act and Assert
    assertEquals("yyyy-MM-dd/", WebUtilities.mkPath("yyyy-MM-dd", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd} and {@code /}.</li>
   *   <li>Then return {@code yyyy-MM-dd/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'yyyy-MM-dd' and '/'; then return 'yyyy-MM-dd/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenYyyyMmDdAndSlash_thenReturnYyyyMmDd2() {
    // Arrange, Act and Assert
    assertEquals("yyyy-MM-dd/", WebUtilities.mkPath("yyyy-MM-dd", "/", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd} and {@code ttf}.</li>
   *   <li>Then return {@code yyyy-MM-dd/ttf/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'yyyy-MM-dd' and 'ttf'; then return 'yyyy-MM-dd/ttf/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenYyyyMmDdAndTtf_thenReturnYyyyMmDdTtf() {
    // Arrange, Act and Assert
    assertEquals("yyyy-MM-dd/ttf/", WebUtilities.mkPath("yyyy-MM-dd", "ttf", "/"));
  }

  /**
   * Test {@link WebUtilities#mkPath(String[])}.
   * <ul>
   *   <li>When {@code yyyy-MM-dd} and {@code yyyy-MM-dd}.</li>
   *   <li>Then return {@code yyyy-MM-dd/yyyy-MM-dd/}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#mkPath(String[])}
   */
  @Test
  @DisplayName("Test mkPath(String[]); when 'yyyy-MM-dd' and 'yyyy-MM-dd'; then return 'yyyy-MM-dd/yyyy-MM-dd/'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.mkPath(String[])"})
  void testMkPath_whenYyyyMmDdAndYyyyMmDd_thenReturnYyyyMmDdYyyyMmDd() {
    // Arrange, Act and Assert
    assertEquals("yyyy-MM-dd/yyyy-MM-dd/", WebUtilities.mkPath("yyyy-MM-dd", "yyyy-MM-dd", "/"));
  }

  /**
   * Test {@link WebUtilities#attemptRender(Response, Object, Logger)}.
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException(String)} with {@code res must not be null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#attemptRender(Response, Object, Logger)}
   */
  @Test
  @DisplayName("Test attemptRender(Response, Object, Logger); given IllegalArgumentException(String) with 'res must not be null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WebUtilities.attemptRender(Response, Object, Logger)"})
  void testAttemptRender_givenIllegalArgumentExceptionWithResMustNotBeNull() {
    // Arrange
    Response res = mock(Response.class);
    doThrow(new IllegalArgumentException("res must not be null")).when(res).body(Mockito.<String>any());

    // Act
    WebUtilities.attemptRender(res, "Obj", new SubstituteLogger("Name", new LinkedList<>(), true));

    // Assert
    verify(res).body(eq("\"Obj\""));
  }

  /**
   * Test {@link WebUtilities#attemptRender(Response, Object, Logger)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then calls {@link Response#body(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#attemptRender(Response, Object, Logger)}
   */
  @Test
  @DisplayName("Test attemptRender(Response, Object, Logger); when one; then calls body(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WebUtilities.attemptRender(Response, Object, Logger)"})
  void testAttemptRender_whenOne_thenCallsBody() {
    // Arrange
    Response res = mock(Response.class);
    doNothing().when(res).body(Mockito.<String>any());

    // Act
    WebUtilities.attemptRender(res, 1, new SubstituteLogger("Name", new LinkedList<>(), true));

    // Assert
    verify(res).body(eq("1"));
  }

  /**
   * Test {@link WebUtilities#attemptRender(Response, Object, Logger)}.
   * <ul>
   *   <li>When {@link Response} {@link Response#body(String)} does nothing.</li>
   *   <li>Then calls {@link Response#body(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#attemptRender(Response, Object, Logger)}
   */
  @Test
  @DisplayName("Test attemptRender(Response, Object, Logger); when Response body(String) does nothing; then calls body(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WebUtilities.attemptRender(Response, Object, Logger)"})
  void testAttemptRender_whenResponseBodyDoesNothing_thenCallsBody() {
    // Arrange
    Response res = mock(Response.class);
    doNothing().when(res).body(Mockito.<String>any());

    // Act
    WebUtilities.attemptRender(res, "Obj", new SubstituteLogger("Name", new LinkedList<>(), true));

    // Assert
    verify(res).body(eq("\"Obj\""));
  }

  /**
   * Test {@link WebUtilities#getLong(Request, String)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link Request} {@link Request#params(String)} return {@code 42}.</li>
   *   <li>Then return forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#getLong(Request, String)}
   */
  @Test
  @DisplayName("Test getLong(Request, String); given '42'; when Request params(String) return '42'; then return forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long WebUtilities.getLong(Request, String)"})
  void testGetLong_given42_whenRequestParamsReturn42_thenReturnFortyTwo() {
    // Arrange
    Request request = mock(Request.class);
    when(request.params(Mockito.<String>any())).thenReturn("42");

    // Act
    long actualLong = WebUtilities.getLong(request, "Param Name");

    // Assert
    verify(request).params(eq("Param Name"));
    assertEquals(42L, actualLong);
  }

  /**
   * Test {@link WebUtilities#getLong(Request, String)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#getLong(Request, String)}
   */
  @Test
  @DisplayName("Test getLong(Request, String); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long WebUtilities.getLong(Request, String)"})
  void testGetLong_thenThrowIllegalArgumentException() {
    // Arrange
    Request request = mock(Request.class);
    when(request.params(Mockito.<String>any())).thenThrow(new IllegalArgumentException("request must not be null"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> WebUtilities.getLong(request, "Param Name"));
    verify(request).params(eq("Param Name"));
  }

  /**
   * Test {@link WebUtilities#getInt(Request, String)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link Request} {@link Request#params(String)} return {@code 42}.</li>
   *   <li>Then return forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#getInt(Request, String)}
   */
  @Test
  @DisplayName("Test getInt(Request, String); given '42'; when Request params(String) return '42'; then return forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int WebUtilities.getInt(Request, String)"})
  void testGetInt_given42_whenRequestParamsReturn42_thenReturnFortyTwo() {
    // Arrange
    Request request = mock(Request.class);
    when(request.params(Mockito.<String>any())).thenReturn("42");

    // Act
    int actualInt = WebUtilities.getInt(request, "Param Name");

    // Assert
    verify(request).params(eq("Param Name"));
    assertEquals(42, actualInt);
  }

  /**
   * Test {@link WebUtilities#getInt(Request, String)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#getInt(Request, String)}
   */
  @Test
  @DisplayName("Test getInt(Request, String); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int WebUtilities.getInt(Request, String)"})
  void testGetInt_thenThrowIllegalArgumentException() {
    // Arrange
    Request request = mock(Request.class);
    when(request.params(Mockito.<String>any())).thenThrow(new IllegalArgumentException("request must not be null"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> WebUtilities.getInt(request, "Param Name"));
    verify(request).params(eq("Param Name"));
  }

  /**
   * Test {@link WebUtilities#getId(Request)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link Request} {@link Request#params(String)} return {@code 42}.</li>
   *   <li>Then return forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#getId(Request)}
   */
  @Test
  @DisplayName("Test getId(Request); given '42'; when Request params(String) return '42'; then return forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long WebUtilities.getId(Request)"})
  void testGetId_given42_whenRequestParamsReturn42_thenReturnFortyTwo() {
    // Arrange
    Request request = mock(Request.class);
    when(request.params(Mockito.<String>any())).thenReturn("42");

    // Act
    long actualId = WebUtilities.getId(request);

    // Assert
    verify(request).params(eq("id"));
    assertEquals(42L, actualId);
  }

  /**
   * Test {@link WebUtilities#getId(Request)}.
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException(String)} with {@code id}.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#getId(Request)}
   */
  @Test
  @DisplayName("Test getId(Request); given IllegalArgumentException(String) with 'id'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long WebUtilities.getId(Request)"})
  void testGetId_givenIllegalArgumentExceptionWithId_thenThrowIllegalArgumentException() {
    // Arrange
    Request request = mock(Request.class);
    when(request.params(Mockito.<String>any())).thenThrow(new IllegalArgumentException("id"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> WebUtilities.getId(request));
    verify(request).params(eq("id"));
  }

  /**
   * Test {@link WebUtilities#requireEditRoleForEntity(UserRoleService, Request, EntityKind, Operation, EntityKind)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#requireEditRoleForEntity(UserRoleService, Request, EntityKind, Operation, EntityKind)}
   */
  @Test
  @DisplayName("Test requireEditRoleForEntity(UserRoleService, Request, EntityKind, Operation, EntityKind); given empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void WebUtilities.requireEditRoleForEntity(UserRoleService, Request, EntityKind, Operation, EntityKind)"})
  void testRequireEditRoleForEntity_givenEmptyString() {
    // Arrange
    UserRoleService userRoleService = mock(UserRoleService.class);
    Request req = mock(Request.class);
    when(req.attribute(Mockito.<String>any())).thenReturn("");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> WebUtilities.requireEditRoleForEntity(userRoleService, req,
        EntityKind.ALL, Operation.ADD, EntityKind.ALL));
    verify(req).attribute(eq("waltz-user"));
  }

  /**
   * Test {@link WebUtilities#requireEditRoleForEntity(UserRoleService, Request, EntityKind, Operation, EntityKind)}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>Then throw {@link NotAuthorizedException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#requireEditRoleForEntity(UserRoleService, Request, EntityKind, Operation, EntityKind)}
   */
  @Test
  @DisplayName("Test requireEditRoleForEntity(UserRoleService, Request, EntityKind, Operation, EntityKind); given HashSet(); then throw NotAuthorizedException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void WebUtilities.requireEditRoleForEntity(UserRoleService, Request, EntityKind, Operation, EntityKind)"})
  void testRequireEditRoleForEntity_givenHashSet_thenThrowNotAuthorizedException() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    Request req = mock(Request.class);
    when(req.attribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act and Assert
    assertThrows(NotAuthorizedException.class, () -> WebUtilities.requireEditRoleForEntity(userRoleService, req,
        EntityKind.ALL, Operation.ADD, EntityKind.ALL));
    verify(userRoleDao).getUserRoles(eq("Attribute"));
    verify(req).attribute(eq("waltz-user"));
  }

  /**
   * Test {@link WebUtilities#requireEditRoleForEntity(UserRoleService, Request, EntityKind, Operation, EntityKind)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Request} {@link Request#attribute(String)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#requireEditRoleForEntity(UserRoleService, Request, EntityKind, Operation, EntityKind)}
   */
  @Test
  @DisplayName("Test requireEditRoleForEntity(UserRoleService, Request, EntityKind, Operation, EntityKind); given 'null'; when Request attribute(String) return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void WebUtilities.requireEditRoleForEntity(UserRoleService, Request, EntityKind, Operation, EntityKind)"})
  void testRequireEditRoleForEntity_givenNull_whenRequestAttributeReturnNull() {
    // Arrange
    UserRoleService userRoleService = mock(UserRoleService.class);
    Request req = mock(Request.class);
    when(req.attribute(Mockito.<String>any())).thenReturn(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> WebUtilities.requireEditRoleForEntity(userRoleService, req,
        EntityKind.ALL, Operation.ADD, EntityKind.ALL));
    verify(req).attribute(eq("waltz-user"));
  }

  /**
   * Test {@link WebUtilities#requireEditRoleForEntity(UserRoleService, Request, EntityKind, Operation, EntityKind)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then calls {@link UserRoleService#hasRole(String, Set)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#requireEditRoleForEntity(UserRoleService, Request, EntityKind, Operation, EntityKind)}
   */
  @Test
  @DisplayName("Test requireEditRoleForEntity(UserRoleService, Request, EntityKind, Operation, EntityKind); given 'true'; then calls hasRole(String, Set)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void WebUtilities.requireEditRoleForEntity(UserRoleService, Request, EntityKind, Operation, EntityKind)"})
  void testRequireEditRoleForEntity_givenTrue_thenCallsHasRole() {
    // Arrange
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), Mockito.<Set<String>>any())).thenReturn(true);
    Request req = mock(Request.class);
    when(req.attribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act
    WebUtilities.requireEditRoleForEntity(userRoleService, req, EntityKind.ALL, Operation.ADD, EntityKind.ALL);

    // Assert
    verify(userRoleService).hasRole(eq("Attribute"), isA(Set.class));
    verify(req).attribute(eq("waltz-user"));
  }

  /**
   * Test {@link WebUtilities#requireEditRoleForEntity(UserRoleService, Request, EntityKind, Operation, EntityKind)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@code ACTOR}.</li>
   *   <li>Then calls {@link UserRoleService#hasRole(String, Set)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#requireEditRoleForEntity(UserRoleService, Request, EntityKind, Operation, EntityKind)}
   */
  @Test
  @DisplayName("Test requireEditRoleForEntity(UserRoleService, Request, EntityKind, Operation, EntityKind); given 'true'; when 'ACTOR'; then calls hasRole(String, Set)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void WebUtilities.requireEditRoleForEntity(UserRoleService, Request, EntityKind, Operation, EntityKind)"})
  void testRequireEditRoleForEntity_givenTrue_whenActor_thenCallsHasRole() {
    // Arrange
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), Mockito.<Set<String>>any())).thenReturn(true);
    Request req = mock(Request.class);
    when(req.attribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act
    WebUtilities.requireEditRoleForEntity(userRoleService, req, EntityKind.ACTOR, Operation.ADD, EntityKind.ALL);

    // Assert
    verify(userRoleService).hasRole(eq("Attribute"), isA(Set.class));
    verify(req).attribute(eq("waltz-user"));
  }

  /**
   * Test {@link WebUtilities#requireEditRoleForEntity(UserRoleService, Request, EntityKind, Operation, EntityKind)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@code APPLICATION}.</li>
   *   <li>Then calls {@link UserRoleService#hasRole(String, Set)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#requireEditRoleForEntity(UserRoleService, Request, EntityKind, Operation, EntityKind)}
   */
  @Test
  @DisplayName("Test requireEditRoleForEntity(UserRoleService, Request, EntityKind, Operation, EntityKind); given 'true'; when 'APPLICATION'; then calls hasRole(String, Set)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void WebUtilities.requireEditRoleForEntity(UserRoleService, Request, EntityKind, Operation, EntityKind)"})
  void testRequireEditRoleForEntity_givenTrue_whenApplication_thenCallsHasRole() {
    // Arrange
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), Mockito.<Set<String>>any())).thenReturn(true);
    Request req = mock(Request.class);
    when(req.attribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act
    WebUtilities.requireEditRoleForEntity(userRoleService, req, EntityKind.APPLICATION, Operation.ADD, EntityKind.ALL);

    // Assert
    verify(userRoleService).hasRole(eq("Attribute"), isA(Set.class));
    verify(req).attribute(eq("waltz-user"));
  }

  /**
   * Test {@link WebUtilities#requireEditRoleForEntity(UserRoleService, Request, EntityKind, Operation, EntityKind)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@code CHANGE_INITIATIVE}.</li>
   *   <li>Then calls {@link UserRoleService#hasRole(String, Set)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#requireEditRoleForEntity(UserRoleService, Request, EntityKind, Operation, EntityKind)}
   */
  @Test
  @DisplayName("Test requireEditRoleForEntity(UserRoleService, Request, EntityKind, Operation, EntityKind); given 'true'; when 'CHANGE_INITIATIVE'; then calls hasRole(String, Set)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "void WebUtilities.requireEditRoleForEntity(UserRoleService, Request, EntityKind, Operation, EntityKind)"})
  void testRequireEditRoleForEntity_givenTrue_whenChangeInitiative_thenCallsHasRole() {
    // Arrange
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), Mockito.<Set<String>>any())).thenReturn(true);
    Request req = mock(Request.class);
    when(req.attribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act
    WebUtilities.requireEditRoleForEntity(userRoleService, req, EntityKind.CHANGE_INITIATIVE, Operation.ADD,
        EntityKind.ALL);

    // Assert
    verify(userRoleService).hasRole(eq("Attribute"), isA(Set.class));
    verify(req).attribute(eq("waltz-user"));
  }

  /**
   * Test {@link WebUtilities#requireRole(UserRoleService, Request, Set)} with {@code UserRoleService}, {@code Request}, {@code Set}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>Then calls {@link UserRoleDao#getUserRoles(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#requireRole(UserRoleService, Request, Set)}
   */
  @Test
  @DisplayName("Test requireRole(UserRoleService, Request, Set) with 'UserRoleService', 'Request', 'Set'; given HashSet(); then calls getUserRoles(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WebUtilities.requireRole(UserRoleService, Request, Set)"})
  void testRequireRoleWithUserRoleServiceRequestSet_givenHashSet_thenCallsGetUserRoles() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    Request request = mock(Request.class);
    when(request.attribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act
    WebUtilities.requireRole(userRoleService, request, new HashSet<>());

    // Assert
    verify(userRoleDao).getUserRoles(eq("Attribute"));
    verify(request).attribute(eq("waltz-user"));
  }

  /**
   * Test {@link WebUtilities#requireRole(UserRoleService, Request, Set)} with {@code UserRoleService}, {@code Request}, {@code Set}.
   * <ul>
   *   <li>Given {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#requireRole(UserRoleService, Request, Set)}
   */
  @Test
  @DisplayName("Test requireRole(UserRoleService, Request, Set) with 'UserRoleService', 'Request', 'Set'; given 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WebUtilities.requireRole(UserRoleService, Request, Set)"})
  void testRequireRoleWithUserRoleServiceRequestSet_givenTrue() {
    // Arrange
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), Mockito.<Set<String>>any())).thenReturn(true);
    Request request = mock(Request.class);
    when(request.attribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act
    WebUtilities.requireRole(userRoleService, request, new HashSet<>());

    // Assert
    verify(userRoleService).hasRole(eq("Attribute"), isA(Set.class));
    verify(request).attribute(eq("waltz-user"));
  }

  /**
   * Test {@link WebUtilities#requireRole(UserRoleService, Request, Set)} with {@code UserRoleService}, {@code Request}, {@code Set}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#requireRole(UserRoleService, Request, Set)}
   */
  @Test
  @DisplayName("Test requireRole(UserRoleService, Request, Set) with 'UserRoleService', 'Request', 'Set'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WebUtilities.requireRole(UserRoleService, Request, Set)"})
  void testRequireRoleWithUserRoleServiceRequestSet_thenThrowIllegalArgumentException() {
    // Arrange
    UserRoleService userRoleService = mock(UserRoleService.class);
    Request request = mock(Request.class);
    when(request.attribute(Mockito.<String>any())).thenReturn("");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> WebUtilities.requireRole(userRoleService, request, new HashSet<>()));
    verify(request).attribute(eq("waltz-user"));
  }

  /**
   * Test {@link WebUtilities#requireRole(UserRoleService, Request, Set)} with {@code UserRoleService}, {@code Request}, {@code Set}.
   * <ul>
   *   <li>Then throw {@link NotAuthorizedException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#requireRole(UserRoleService, Request, Set)}
   */
  @Test
  @DisplayName("Test requireRole(UserRoleService, Request, Set) with 'UserRoleService', 'Request', 'Set'; then throw NotAuthorizedException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WebUtilities.requireRole(UserRoleService, Request, Set)"})
  void testRequireRoleWithUserRoleServiceRequestSet_thenThrowNotAuthorizedException() {
    // Arrange
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), Mockito.<Set<String>>any())).thenReturn(false);
    Request request = mock(Request.class);
    when(request.attribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act and Assert
    assertThrows(NotAuthorizedException.class,
        () -> WebUtilities.requireRole(userRoleService, request, new HashSet<>()));
    verify(userRoleService).hasRole(eq("Attribute"), isA(Set.class));
    verify(request).attribute(eq("waltz-user"));
  }

  /**
   * Test {@link WebUtilities#requireRole(UserRoleService, Request, String[])} with {@code UserRoleService}, {@code Request}, {@code String[]}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#requireRole(UserRoleService, Request, String[])}
   */
  @Test
  @DisplayName("Test requireRole(UserRoleService, Request, String[]) with 'UserRoleService', 'Request', 'String[]'; given empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WebUtilities.requireRole(UserRoleService, Request, String[])"})
  void testRequireRoleWithUserRoleServiceRequestString_givenEmptyString() {
    // Arrange
    UserRoleService userRoleService = mock(UserRoleService.class);
    Request request = mock(Request.class);
    when(request.attribute(Mockito.<String>any())).thenReturn("");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> WebUtilities.requireRole(userRoleService, request, "Required Roles"));
    verify(request).attribute(eq("waltz-user"));
  }

  /**
   * Test {@link WebUtilities#requireRole(UserRoleService, Request, String[])} with {@code UserRoleService}, {@code Request}, {@code String[]}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#requireRole(UserRoleService, Request, String[])}
   */
  @Test
  @DisplayName("Test requireRole(UserRoleService, Request, String[]) with 'UserRoleService', 'Request', 'String[]'; given 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WebUtilities.requireRole(UserRoleService, Request, String[])"})
  void testRequireRoleWithUserRoleServiceRequestString_givenNull() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    Request request = mock(Request.class);
    when(request.attribute(Mockito.<String>any())).thenReturn(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> WebUtilities.requireRole(userRoleService, request, (String[]) null));
    verify(request).attribute(eq("waltz-user"));
  }

  /**
   * Test {@link WebUtilities#requireRole(UserRoleService, Request, String[])} with {@code UserRoleService}, {@code Request}, {@code String[]}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then calls {@link UserRoleService#hasRole(String, Set)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#requireRole(UserRoleService, Request, String[])}
   */
  @Test
  @DisplayName("Test requireRole(UserRoleService, Request, String[]) with 'UserRoleService', 'Request', 'String[]'; given 'true'; then calls hasRole(String, Set)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WebUtilities.requireRole(UserRoleService, Request, String[])"})
  void testRequireRoleWithUserRoleServiceRequestString_givenTrue_thenCallsHasRole() {
    // Arrange
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), Mockito.<Set<String>>any())).thenReturn(true);
    Request request = mock(Request.class);
    when(request.attribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act
    WebUtilities.requireRole(userRoleService, request, "Required Roles");

    // Assert
    verify(userRoleService).hasRole(eq("Attribute"), isA(Set.class));
    verify(request).attribute(eq("waltz-user"));
  }

  /**
   * Test {@link WebUtilities#requireRole(UserRoleService, Request, String[])} with {@code UserRoleService}, {@code Request}, {@code String[]}.
   * <ul>
   *   <li>Then calls {@link UserRoleDao#getUserRoles(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#requireRole(UserRoleService, Request, String[])}
   */
  @Test
  @DisplayName("Test requireRole(UserRoleService, Request, String[]) with 'UserRoleService', 'Request', 'String[]'; then calls getUserRoles(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WebUtilities.requireRole(UserRoleService, Request, String[])"})
  void testRequireRoleWithUserRoleServiceRequestString_thenCallsGetUserRoles() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    Request request = mock(Request.class);
    when(request.attribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act
    WebUtilities.requireRole(userRoleService, request, (String[]) null);

    // Assert
    verify(userRoleDao).getUserRoles(eq("Attribute"));
    verify(request).attribute(eq("waltz-user"));
  }

  /**
   * Test {@link WebUtilities#requireRole(UserRoleService, Request, String[])} with {@code UserRoleService}, {@code Request}, {@code String[]}.
   * <ul>
   *   <li>Then throw {@link NotAuthorizedException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#requireRole(UserRoleService, Request, String[])}
   */
  @Test
  @DisplayName("Test requireRole(UserRoleService, Request, String[]) with 'UserRoleService', 'Request', 'String[]'; then throw NotAuthorizedException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WebUtilities.requireRole(UserRoleService, Request, String[])"})
  void testRequireRoleWithUserRoleServiceRequestString_thenThrowNotAuthorizedException() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    Request request = mock(Request.class);
    when(request.attribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act and Assert
    assertThrows(NotAuthorizedException.class,
        () -> WebUtilities.requireRole(userRoleService, request, "Required Roles"));
    verify(userRoleDao).getUserRoles(eq("Attribute"));
    verify(request).attribute(eq("waltz-user"));
  }

  /**
   * Test {@link WebUtilities#requireRole(UserRoleService, Request, SystemRole[])} with {@code UserRoleService}, {@code Request}, {@code SystemRole[]}.
   * <p>
   * Method under test: {@link WebUtilities#requireRole(UserRoleService, Request, SystemRole[])}
   */
  @Test
  @DisplayName("Test requireRole(UserRoleService, Request, SystemRole[]) with 'UserRoleService', 'Request', 'SystemRole[]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WebUtilities.requireRole(UserRoleService, Request, SystemRole[])"})
  void testRequireRoleWithUserRoleServiceRequestSystemRole() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    Request request = mock(Request.class);
    when(request.attribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act and Assert
    assertThrows(NotAuthorizedException.class,
        () -> WebUtilities.requireRole(userRoleService, request, SystemRole.ACTOR_ADMIN));
    verify(userRoleDao).getUserRoles(eq("Attribute"));
    verify(request).attribute(eq("waltz-user"));
  }

  /**
   * Test {@link WebUtilities#requireRole(UserRoleService, Request, SystemRole[])} with {@code UserRoleService}, {@code Request}, {@code SystemRole[]}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#requireRole(UserRoleService, Request, SystemRole[])}
   */
  @Test
  @DisplayName("Test requireRole(UserRoleService, Request, SystemRole[]) with 'UserRoleService', 'Request', 'SystemRole[]'; given empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WebUtilities.requireRole(UserRoleService, Request, SystemRole[])"})
  void testRequireRoleWithUserRoleServiceRequestSystemRole_givenEmptyString() {
    // Arrange
    UserRoleService userRoleService = mock(UserRoleService.class);
    Request request = mock(Request.class);
    when(request.attribute(Mockito.<String>any())).thenReturn("");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> WebUtilities.requireRole(userRoleService, request, SystemRole.ACTOR_ADMIN));
    verify(request).attribute(eq("waltz-user"));
  }

  /**
   * Test {@link WebUtilities#requireRole(UserRoleService, Request, SystemRole[])} with {@code UserRoleService}, {@code Request}, {@code SystemRole[]}.
   * <ul>
   *   <li>Given {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#requireRole(UserRoleService, Request, SystemRole[])}
   */
  @Test
  @DisplayName("Test requireRole(UserRoleService, Request, SystemRole[]) with 'UserRoleService', 'Request', 'SystemRole[]'; given 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WebUtilities.requireRole(UserRoleService, Request, SystemRole[])"})
  void testRequireRoleWithUserRoleServiceRequestSystemRole_givenNull() {
    // Arrange
    UserRoleService userRoleService = mock(UserRoleService.class);
    Request request = mock(Request.class);
    when(request.attribute(Mockito.<String>any())).thenReturn(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> WebUtilities.requireRole(userRoleService, request, SystemRole.ACTOR_ADMIN));
    verify(request).attribute(eq("waltz-user"));
  }

  /**
   * Test {@link WebUtilities#requireRole(UserRoleService, Request, SystemRole[])} with {@code UserRoleService}, {@code Request}, {@code SystemRole[]}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then calls {@link UserRoleService#hasRole(String, Set)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#requireRole(UserRoleService, Request, SystemRole[])}
   */
  @Test
  @DisplayName("Test requireRole(UserRoleService, Request, SystemRole[]) with 'UserRoleService', 'Request', 'SystemRole[]'; given 'true'; then calls hasRole(String, Set)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WebUtilities.requireRole(UserRoleService, Request, SystemRole[])"})
  void testRequireRoleWithUserRoleServiceRequestSystemRole_givenTrue_thenCallsHasRole() {
    // Arrange
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasRole(Mockito.<String>any(), Mockito.<Set<String>>any())).thenReturn(true);
    Request request = mock(Request.class);
    when(request.attribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act
    WebUtilities.requireRole(userRoleService, request, SystemRole.ACTOR_ADMIN);

    // Assert
    verify(userRoleService).hasRole(eq("Attribute"), isA(Set.class));
    verify(request).attribute(eq("waltz-user"));
  }

  /**
   * Test {@link WebUtilities#requireRole(UserRoleService, Request, SystemRole[])} with {@code UserRoleService}, {@code Request}, {@code SystemRole[]}.
   * <ul>
   *   <li>Then calls {@link UserRoleDao#getUserRoles(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#requireRole(UserRoleService, Request, SystemRole[])}
   */
  @Test
  @DisplayName("Test requireRole(UserRoleService, Request, SystemRole[]) with 'UserRoleService', 'Request', 'SystemRole[]'; then calls getUserRoles(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WebUtilities.requireRole(UserRoleService, Request, SystemRole[])"})
  void testRequireRoleWithUserRoleServiceRequestSystemRole_thenCallsGetUserRoles() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    Request request = mock(Request.class);
    when(request.attribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act
    WebUtilities.requireRole(userRoleService, request, (SystemRole[]) null);

    // Assert
    verify(userRoleDao).getUserRoles(eq("Attribute"));
    verify(request).attribute(eq("waltz-user"));
  }

  /**
   * Test {@link WebUtilities#requireAnyRole(UserRoleService, Request, SystemRole[])}.
   * <ul>
   *   <li>Given empty string.</li>
   *   <li>When {@link UserRoleService}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#requireAnyRole(UserRoleService, Request, SystemRole[])}
   */
  @Test
  @DisplayName("Test requireAnyRole(UserRoleService, Request, SystemRole[]); given empty string; when UserRoleService")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WebUtilities.requireAnyRole(UserRoleService, Request, SystemRole[])"})
  void testRequireAnyRole_givenEmptyString_whenUserRoleService() {
    // Arrange
    UserRoleService userRoleService = mock(UserRoleService.class);
    Request request = mock(Request.class);
    when(request.attribute(Mockito.<String>any())).thenReturn("");

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> WebUtilities.requireAnyRole(userRoleService, request, SystemRole.ACTOR_ADMIN));
    verify(request).attribute(eq("waltz-user"));
  }

  /**
   * Test {@link WebUtilities#requireAnyRole(UserRoleService, Request, SystemRole[])}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>Then throw {@link NotAuthorizedException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#requireAnyRole(UserRoleService, Request, SystemRole[])}
   */
  @Test
  @DisplayName("Test requireAnyRole(UserRoleService, Request, SystemRole[]); given HashSet(); then throw NotAuthorizedException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WebUtilities.requireAnyRole(UserRoleService, Request, SystemRole[])"})
  void testRequireAnyRole_givenHashSet_thenThrowNotAuthorizedException() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    Request request = mock(Request.class);
    when(request.attribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act and Assert
    assertThrows(NotAuthorizedException.class,
        () -> WebUtilities.requireAnyRole(userRoleService, request, SystemRole.ACTOR_ADMIN));
    verify(userRoleDao).getUserRoles(eq("Attribute"));
    verify(request).attribute(eq("waltz-user"));
  }

  /**
   * Test {@link WebUtilities#requireAnyRole(UserRoleService, Request, SystemRole[])}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>Then throw {@link NotAuthorizedException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#requireAnyRole(UserRoleService, Request, SystemRole[])}
   */
  @Test
  @DisplayName("Test requireAnyRole(UserRoleService, Request, SystemRole[]); given HashSet(); then throw NotAuthorizedException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WebUtilities.requireAnyRole(UserRoleService, Request, SystemRole[])"})
  void testRequireAnyRole_givenHashSet_thenThrowNotAuthorizedException2() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    Request request = mock(Request.class);
    when(request.attribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act and Assert
    assertThrows(NotAuthorizedException.class, () -> WebUtilities.requireAnyRole(userRoleService, request, null));
    verify(userRoleDao).getUserRoles(eq("Attribute"));
    verify(request).attribute(eq("waltz-user"));
  }

  /**
   * Test {@link WebUtilities#requireAnyRole(UserRoleService, Request, SystemRole[])}.
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.</li>
   *   <li>Then throw {@link NotAuthorizedException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#requireAnyRole(UserRoleService, Request, SystemRole[])}
   */
  @Test
  @DisplayName("Test requireAnyRole(UserRoleService, Request, SystemRole[]); given HashSet(); then throw NotAuthorizedException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WebUtilities.requireAnyRole(UserRoleService, Request, SystemRole[])"})
  void testRequireAnyRole_givenHashSet_thenThrowNotAuthorizedException3() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    when(userRoleDao.getUserRoles(Mockito.<String>any())).thenReturn(new HashSet<>());
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    Request request = mock(Request.class);
    when(request.attribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act and Assert
    assertThrows(NotAuthorizedException.class, () -> WebUtilities.requireAnyRole(userRoleService, request));
    verify(userRoleDao).getUserRoles(eq("Attribute"));
    verify(request).attribute(eq("waltz-user"));
  }

  /**
   * Test {@link WebUtilities#requireAnyRole(UserRoleService, Request, SystemRole[])}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Request} {@link Request#attribute(String)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#requireAnyRole(UserRoleService, Request, SystemRole[])}
   */
  @Test
  @DisplayName("Test requireAnyRole(UserRoleService, Request, SystemRole[]); given 'null'; when Request attribute(String) return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WebUtilities.requireAnyRole(UserRoleService, Request, SystemRole[])"})
  void testRequireAnyRole_givenNull_whenRequestAttributeReturnNull() {
    // Arrange
    UserRoleDao userRoleDao = mock(UserRoleDao.class);
    RoleDao roleDao = mock(RoleDao.class);
    PersonDao personDao = mock(PersonDao.class);
    ChangeLogService changeLogService = new ChangeLogService(mock(ChangeLogDao.class),
        mock(ChangeLogSummariesDao.class), mock(PhysicalFlowDao.class), mock(PhysicalSpecificationDao.class),
        mock(LogicalFlowDao.class), mock(ApplicationDao.class), mock(MeasurableRatingReplacementDao.class),
        mock(MeasurableRatingDao.class), mock(MeasurableRatingPlannedDecommissionDao.class),
        mock(EntityReferenceNameResolver.class));

    PersonService personService = new PersonService(mock(PersonDao.class), mock(PersonSearchDao.class));

    SettingsDao settingsDao = mock(SettingsDao.class);
    UserRoleService userRoleService = new UserRoleService(userRoleDao, roleDao, personDao, changeLogService,
        personService, new SettingsService(settingsDao, new ArrayList<>()));

    Request request = mock(Request.class);
    when(request.attribute(Mockito.<String>any())).thenReturn(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> WebUtilities.requireAnyRole(userRoleService, request, null));
    verify(request).attribute(eq("waltz-user"));
  }

  /**
   * Test {@link WebUtilities#requireAnyRole(UserRoleService, Request, SystemRole[])}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then calls {@link UserRoleService#hasAnyRole(String, SystemRole[])}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#requireAnyRole(UserRoleService, Request, SystemRole[])}
   */
  @Test
  @DisplayName("Test requireAnyRole(UserRoleService, Request, SystemRole[]); given 'true'; then calls hasAnyRole(String, SystemRole[])")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WebUtilities.requireAnyRole(UserRoleService, Request, SystemRole[])"})
  void testRequireAnyRole_givenTrue_thenCallsHasAnyRole() {
    // Arrange
    UserRoleService userRoleService = mock(UserRoleService.class);
    when(userRoleService.hasAnyRole(Mockito.<String>any(), (SystemRole[]) Mockito.any())).thenReturn(true);
    Request request = mock(Request.class);
    when(request.attribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act
    WebUtilities.requireAnyRole(userRoleService, request, SystemRole.ACTOR_ADMIN);

    // Assert
    verify(userRoleService).hasAnyRole(eq("Attribute"), (SystemRole[]) Mockito.any());
    verify(request).attribute(eq("waltz-user"));
  }

  /**
   * Test {@link WebUtilities#getUsername(Request)}.
   * <ul>
   *   <li>Given {@code Attribute}.</li>
   *   <li>Then return {@code Attribute}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#getUsername(Request)}
   */
  @Test
  @DisplayName("Test getUsername(Request); given 'Attribute'; then return 'Attribute'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.getUsername(Request)"})
  void testGetUsername_givenAttribute_thenReturnAttribute() {
    // Arrange
    Request request = mock(Request.class);
    when(request.attribute(Mockito.<String>any())).thenReturn("Attribute");

    // Act
    String actualUsername = WebUtilities.getUsername(request);

    // Assert
    verify(request).attribute(eq("waltz-user"));
    assertEquals("Attribute", actualUsername);
  }

  /**
   * Test {@link WebUtilities#getKind(Request, String)} with {@code request}, {@code paramName}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#getKind(Request, String)}
   */
  @Test
  @DisplayName("Test getKind(Request, String) with 'request', 'paramName'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityKind WebUtilities.getKind(Request, String)"})
  void testGetKindWithRequestParamName_thenThrowIllegalArgumentException() {
    // Arrange
    Request request = mock(Request.class);
    when(request.params(Mockito.<String>any())).thenThrow(new IllegalArgumentException("request must not be null"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> WebUtilities.getKind(request, "Param Name"));
    verify(request).params(eq("Param Name"));
  }

  /**
   * Test {@link WebUtilities#getKind(Request)} with {@code request}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#getKind(Request)}
   */
  @Test
  @DisplayName("Test getKind(Request) with 'request'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityKind WebUtilities.getKind(Request)"})
  void testGetKindWithRequest_thenThrowIllegalArgumentException() {
    // Arrange
    Request request = mock(Request.class);
    when(request.params(Mockito.<String>any())).thenThrow(new IllegalArgumentException("kind"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> WebUtilities.getKind(request));
    verify(request).params(eq("kind"));
  }

  /**
   * Test {@link WebUtilities#readBody(Request, Class, Object)} with {@code request}, {@code objClass}, {@code dflt}.
   * <ul>
   *   <li>Given {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   *   <li>Then return {@code Dflt}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#readBody(Request, Class, Object)}
   */
  @Test
  @DisplayName("Test readBody(Request, Class, Object) with 'request', 'objClass', 'dflt'; given 'AXAXAXAX' Bytes is 'UTF-8'; then return 'Dflt'")
  @Tag("MaintainedByDiffblue")
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
   * Test {@link WebUtilities#readBody(Request, Class, Object)} with {@code request}, {@code objClass}, {@code dflt}.
   * <ul>
   *   <li>Given empty array of {@code byte}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#readBody(Request, Class, Object)}
   */
  @Test
  @DisplayName("Test readBody(Request, Class, Object) with 'request', 'objClass', 'dflt'; given empty array of byte")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Object WebUtilities.readBody(Request, Class, Object)"})
  void testReadBodyWithRequestObjClassDflt_givenEmptyArrayOfByte() {
    // Arrange
    Request request = mock(Request.class);
    when(request.bodyAsBytes()).thenReturn(new byte[]{});
    Class<Object> objClass = Object.class;

    // Act
    Object actualReadBodyResult = WebUtilities.readBody(request, objClass, "Dflt");

    // Assert
    verify(request).bodyAsBytes();
    assertEquals("Dflt", actualReadBodyResult);
  }

  /**
   * Test {@link WebUtilities#readEnum(Request, String, Class, Function)}.
   * <ul>
   *   <li>Given {@code Params}.</li>
   *   <li>When {@link Function} {@link Function#apply(Object)} return {@code CONSTANT_ASCENT}.</li>
   *   <li>Then calls {@link Function#apply(Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#readEnum(Request, String, Class, Function)}
   */
  @Test
  @DisplayName("Test readEnum(Request, String, Class, Function); given 'Params'; when Function apply(Object) return 'CONSTANT_ASCENT'; then calls apply(Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Enum WebUtilities.readEnum(Request, String, Class, Function)"})
  void testReadEnum_givenParams_whenFunctionApplyReturnConstantAscent_thenCallsApply() {
    // Arrange
    Request request = mock(Request.class);
    when(request.params(Mockito.<String>any())).thenReturn("Params");
    Class<BaselineResizeBehavior> enumClass = BaselineResizeBehavior.class;
    Function<String, BaselineResizeBehavior> failedParseSupplier = mock(Function.class);
    when(failedParseSupplier.apply(Mockito.<String>any())).thenReturn(BaselineResizeBehavior.CONSTANT_ASCENT);

    // Act
    BaselineResizeBehavior actualReadEnumResult = WebUtilities.readEnum(request, "Param Name", enumClass,
        failedParseSupplier);

    // Assert
    verify(failedParseSupplier).apply(eq("Params"));
    verify(request).params(eq("Param Name"));
    assertEquals(BaselineResizeBehavior.CONSTANT_ASCENT, actualReadEnumResult);
  }

  /**
   * Test {@link WebUtilities#readEnum(Request, String, Class, Function)}.
   * <ul>
   *   <li>When {@link Request} {@link Request#params(String)} return {@code CONSTANT_ASCENT}.</li>
   *   <li>Then return {@code CONSTANT_ASCENT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#readEnum(Request, String, Class, Function)}
   */
  @Test
  @DisplayName("Test readEnum(Request, String, Class, Function); when Request params(String) return 'CONSTANT_ASCENT'; then return 'CONSTANT_ASCENT'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Enum WebUtilities.readEnum(Request, String, Class, Function)"})
  void testReadEnum_whenRequestParamsReturnConstantAscent_thenReturnConstantAscent() {
    // Arrange
    Request request = mock(Request.class);
    when(request.params(Mockito.<String>any())).thenReturn("CONSTANT_ASCENT");
    Class<BaselineResizeBehavior> enumClass = BaselineResizeBehavior.class;

    // Act
    BaselineResizeBehavior actualReadEnumResult = WebUtilities.readEnum(request, "Param Name", enumClass,
        mock(Function.class));

    // Assert
    verify(request).params(eq("Param Name"));
    assertEquals(BaselineResizeBehavior.CONSTANT_ASCENT, actualReadEnumResult);
  }

  /**
   * Test {@link WebUtilities#reportException(int, String, String, Response, Logger)} with {@code statusCode}, {@code errorCode}, {@code message}, {@code res}, {@code log}.
   * <ul>
   *   <li>Then calls {@link Response#body(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#reportException(int, String, String, Response, Logger)}
   */
  @Test
  @DisplayName("Test reportException(int, String, String, Response, Logger) with 'statusCode', 'errorCode', 'message', 'res', 'log'; then calls body(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WebUtilities.reportException(int, String, String, Response, Logger)"})
  void testReportExceptionWithStatusCodeErrorCodeMessageResLog_thenCallsBody() {
    // Arrange
    Response res = mock(Response.class);
    doNothing().when(res).body(Mockito.<String>any());
    doNothing().when(res).status(anyInt());

    // Act
    WebUtilities.reportException(1, "An error occurred", "An error occurred", res,
        new SubstituteLogger("Name", new LinkedList<>(), true));

    // Assert
    verify(res).body(eq("{\"message\":\"An error occurred\",\"id\":\"An error occurred\"}"));
    verify(res).status(eq(1));
  }

  /**
   * Test {@link WebUtilities#reportException(int, Optional, String, Response, Logger)} with {@code statusCode}, {@code maybeErrorCode}, {@code message}, {@code res}, {@code log}.
   * <ul>
   *   <li>Then calls {@link Response#body(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#reportException(int, Optional, String, Response, Logger)}
   */
  @Test
  @DisplayName("Test reportException(int, Optional, String, Response, Logger) with 'statusCode', 'maybeErrorCode', 'message', 'res', 'log'; then calls body(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WebUtilities.reportException(int, Optional, String, Response, Logger)"})
  void testReportExceptionWithStatusCodeMaybeErrorCodeMessageResLog_thenCallsBody() {
    // Arrange
    Optional<String> maybeErrorCode = Optional.of("foo");
    Response res = mock(Response.class);
    doNothing().when(res).body(Mockito.<String>any());
    doNothing().when(res).status(anyInt());

    // Act
    WebUtilities.reportException(1, maybeErrorCode, "An error occurred", res,
        new SubstituteLogger("Name", new LinkedList<>(), true));

    // Assert
    verify(res).body(eq("{\"message\":\"An error occurred\",\"id\":\"foo\"}"));
    verify(res).status(eq(1));
  }

  /**
   * Test {@link WebUtilities#getMimeType(String)}.
   * <ul>
   *   <li>When {@code Path}.</li>
   *   <li>Then return {@code application/octet-stream}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#getMimeType(String)}
   */
  @Test
  @DisplayName("Test getMimeType(String); when 'Path'; then return 'application/octet-stream'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.getMimeType(String)"})
  void testGetMimeType_whenPath_thenReturnApplicationOctetStream() {
    // Arrange, Act and Assert
    assertEquals("application/octet-stream", WebUtilities.getMimeType("Path"));
  }

  /**
   * Test {@link WebUtilities#getMimeType(String)}.
   * <ul>
   *   <li>When {@code ttf}.</li>
   *   <li>Then return {@code application/x-font-ttf}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#getMimeType(String)}
   */
  @Test
  @DisplayName("Test getMimeType(String); when 'ttf'; then return 'application/x-font-ttf'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String WebUtilities.getMimeType(String)"})
  void testGetMimeType_whenTtf_thenReturnApplicationXFontTtf() {
    // Arrange, Act and Assert
    assertEquals("application/x-font-ttf", WebUtilities.getMimeType("ttf"));
  }

  /**
   * Test {@link WebUtilities#getLimit(Request)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>Then return {@link Optional#get()} intValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#getLimit(Request)}
   */
  @Test
  @DisplayName("Test getLimit(Request); given '42'; then return get() intValue is forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional WebUtilities.getLimit(Request)"})
  void testGetLimit_given42_thenReturnGetIntValueIsFortyTwo() {
    // Arrange
    Request request = mock(Request.class);
    when(request.queryParams(Mockito.<String>any())).thenReturn("42");

    // Act
    Optional<Integer> actualLimit = WebUtilities.getLimit(request);

    // Assert
    verify(request).queryParams(eq("limit"));
    assertEquals(42, actualLimit.get().intValue());
    assertTrue(actualLimit.isPresent());
  }

  /**
   * Test {@link WebUtilities#getLimit(Request)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#getLimit(Request)}
   */
  @Test
  @DisplayName("Test getLimit(Request); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional WebUtilities.getLimit(Request)"})
  void testGetLimit_thenThrowIllegalArgumentException() {
    // Arrange
    Request request = mock(Request.class);
    when(request.queryParams(Mockito.<String>any())).thenThrow(new IllegalArgumentException("limit"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> WebUtilities.getLimit(request));
    verify(request).queryParams(eq("limit"));
  }

  /**
   * Test {@link WebUtilities#getDateParam(Request)}.
   * <ul>
   *   <li>Given {@code Query Params}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#getDateParam(Request)}
   */
  @Test
  @DisplayName("Test getDateParam(Request); given 'Query Params'; then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional WebUtilities.getDateParam(Request)"})
  void testGetDateParam_givenQueryParams_thenReturnNotPresent() {
    // Arrange
    Request request = mock(Request.class);
    when(request.queryParams(Mockito.<String>any())).thenReturn("Query Params");

    // Act
    Optional<Date> actualDateParam = WebUtilities.getDateParam(request);

    // Assert
    verify(request).queryParams(eq("date"));
    assertFalse(actualDateParam.isPresent());
  }

  /**
   * Test {@link WebUtilities#getDateParam(Request)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#getDateParam(Request)}
   */
  @Test
  @DisplayName("Test getDateParam(Request); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional WebUtilities.getDateParam(Request)"})
  void testGetDateParam_thenThrowIllegalArgumentException() {
    // Arrange
    Request request = mock(Request.class);
    when(request.queryParams(Mockito.<String>any())).thenThrow(new IllegalArgumentException("date"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> WebUtilities.getDateParam(request));
    verify(request).queryParams(eq("date"));
  }

  /**
   * Test {@link WebUtilities#getLocalDateParam(Request, String)}.
   * <ul>
   *   <li>Given {@code Params}.</li>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#getLocalDateParam(Request, String)}
   */
  @Test
  @DisplayName("Test getLocalDateParam(Request, String); given 'Params'; then return not Present")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional WebUtilities.getLocalDateParam(Request, String)"})
  void testGetLocalDateParam_givenParams_thenReturnNotPresent() {
    // Arrange
    Request request = mock(Request.class);
    when(request.params(Mockito.<String>any())).thenReturn("Params");

    // Act
    Optional<LocalDate> actualLocalDateParam = WebUtilities.getLocalDateParam(request, "Param Name");

    // Assert
    verify(request).params(eq("Param Name"));
    assertFalse(actualLocalDateParam.isPresent());
  }

  /**
   * Test {@link WebUtilities#getLocalDateParam(Request, String)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#getLocalDateParam(Request, String)}
   */
  @Test
  @DisplayName("Test getLocalDateParam(Request, String); then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional WebUtilities.getLocalDateParam(Request, String)"})
  void testGetLocalDateParam_thenThrowIllegalArgumentException() {
    // Arrange
    Request request = mock(Request.class);
    when(request.params(Mockito.<String>any())).thenThrow(new IllegalArgumentException("yyyy-MM-dd"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> WebUtilities.getLocalDateParam(request, "Param Name"));
    verify(request).params(eq("Param Name"));
  }

  /**
   * Test {@link WebUtilities#simplifyMapToList(Map)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link HashMap#HashMap()} {@code 42} is {@code 42}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#simplifyMapToList(Map)}
   */
  @Test
  @DisplayName("Test simplifyMapToList(Map); given '42'; when HashMap() '42' is '42'; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List WebUtilities.simplifyMapToList(Map)"})
  void testSimplifyMapToList_given42_whenHashMap42Is42_thenReturnSizeIsOne() {
    // Arrange
    HashMap<Object, Object> m = new HashMap<>();
    m.put("42", "42");

    // Act
    List<Entry<Object, Object>> actualSimplifyMapToListResult = WebUtilities.simplifyMapToList(m);

    // Assert
    assertEquals(1, actualSimplifyMapToListResult.size());
    Entry<Object, Object> getResult = actualSimplifyMapToListResult.get(0);
    assertTrue(getResult instanceof ImmutableEntry);
    assertEquals("42", getResult.key());
    assertEquals("42", getResult.value());
  }

  /**
   * Test {@link WebUtilities#simplifyMapToList(Map)}.
   * <ul>
   *   <li>Given forty-two.</li>
   *   <li>When {@link HashMap#HashMap()} forty-two is {@code 42}.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#simplifyMapToList(Map)}
   */
  @Test
  @DisplayName("Test simplifyMapToList(Map); given forty-two; when HashMap() forty-two is '42'; then return size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List WebUtilities.simplifyMapToList(Map)"})
  void testSimplifyMapToList_givenFortyTwo_whenHashMapFortyTwoIs42_thenReturnSizeIsTwo() {
    // Arrange
    HashMap<Object, Object> m = new HashMap<>();
    m.put(42, "42");
    m.put("42", "42");

    // Act
    List<Entry<Object, Object>> actualSimplifyMapToListResult = WebUtilities.simplifyMapToList(m);

    // Assert
    assertEquals(2, actualSimplifyMapToListResult.size());
    Entry<Object, Object> getResult = actualSimplifyMapToListResult.get(0);
    assertTrue(getResult instanceof ImmutableEntry);
    Entry<Object, Object> getResult2 = actualSimplifyMapToListResult.get(1);
    assertTrue(getResult2 instanceof ImmutableEntry);
    assertEquals("42", getResult2.key());
    assertEquals("42", getResult2.value());
    assertEquals(42, ((Integer) getResult.key()).intValue());
  }

  /**
   * Test {@link WebUtilities#simplifyMapToList(Map)}.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link WebUtilities#simplifyMapToList(Map)}
   */
  @Test
  @DisplayName("Test simplifyMapToList(Map); when HashMap(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List WebUtilities.simplifyMapToList(Map)"})
  void testSimplifyMapToList_whenHashMap_thenReturnEmpty() {
    // Arrange and Act
    List<Entry<Object, Object>> actualSimplifyMapToListResult = WebUtilities.simplifyMapToList(new HashMap<>());

    // Assert
    assertTrue(actualSimplifyMapToListResult.isEmpty());
  }
}
