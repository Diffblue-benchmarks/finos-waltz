package org.finos.waltz.web.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.finos.waltz.web.json.ImmutableReportGridJSON.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ReportGridJSONDiffblueTest {
  /**
   * Test {@link ReportGridJSON#type()}.
   *
   * <ul>
   *   <li>Then return {@code Type}.
   * </ul>
   *
   * <p>Method under test: {@link ReportGridJSON#type()}
   */
  @Test
  @DisplayName("Test type(); then return 'Type'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String ReportGridJSON.type()"})
  void testType_thenReturnType() {
    // Arrange
    Builder apiTypesResult =
        ImmutableReportGridJSON.builder().apiTypes(ImmutableApiTypes.builder().build());

    ImmutableGrid.Builder builderResult = ImmutableGrid.builder();

    // Act and Assert
    assertEquals(
        "Type",
        apiTypesResult
            .grid(builderResult.columnDescriptors(new ArrayList<>()).build())
            .id("42")
            .name("Name")
            .type("Type")
            .build()
            .type());
  }
}
