package org.finos.waltz.test_common.helpers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.service.external_identifier.ExternalIdentifierService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
class ExternalIdHelperDiffblueTest {
  @InjectMocks
  private ExternalIdHelper externalIdHelper;

  @Mock
  private ExternalIdentifierService externalIdentifierService;

  /**
   * Test {@link ExternalIdHelper#createExtId(EntityReference, String, String)}.
   * <p>
   * Method under test: {@link ExternalIdHelper#createExtId(EntityReference, String, String)}
   */
  @Test
  @DisplayName("Test createExtId(EntityReference, String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int ExternalIdHelper.createExtId(EntityReference, String, String)"})
  void testCreateExtId() {
    // Arrange
    when(externalIdentifierService.create(Mockito.<EntityReference>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(1);

    // Act
    int actualCreateExtIdResult = externalIdHelper.createExtId(null, "42", "Name");

    // Assert
    verify(externalIdentifierService).create(isNull(), eq("42"), eq("Name"));
    assertEquals(1, actualCreateExtIdResult);
  }
}
